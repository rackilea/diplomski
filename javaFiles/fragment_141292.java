package com.mycompany.yetanothercheckbox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;


public class MainApp extends Application {

    private TreeTableView<A> treetable=new TreeTableView<>();
    @Override
    public void start(Stage primaryStage) {
       //setting up parents (A) and children (B)
        A a1=new A();                       
        a1.setName("A1");

        List<A> A1Children=new ArrayList();
        B b11=new B();
        b11.setName("B11");
        B b12=new B();
        b12.setName("B12");
        b11.setParent(a1);
        b12.setParent(a1);
        A1Children.add(b11);
        A1Children.add(b12);
        a1.setChildren(A1Children);


        A a2=new A();
        a2.setName("A2");

        List<A> A2Children=new ArrayList();
        B b21=new B();
        b21.setName("B21");
        B b22=new B();
        b22.setName("B22");
        b21.setParent(a2);
        b22.setParent(a2);
        A2Children.add(b21);
        A2Children.add(b22);
        a2.setChildren(A2Children);



        //tree columns . first one holds strings
        TreeTableColumn<A,String> name=new TreeTableColumn<>("Name");
        name.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));


        //2nd tree columns. rendered as checkboxes. boolean values
        TreeTableColumn<A,Boolean> checks=new TreeTableColumn<>("Checks");
        checks.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<A, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TreeTableColumn.CellDataFeatures<A, Boolean> param) {
                A a=param.getValue().getValue();
                SimpleBooleanProperty checkUncheck=new SimpleBooleanProperty();
                SimpleBooleanProperty indeterminate=new SimpleBooleanProperty();

                checkUncheck.bindBidirectional(a.getCheck().getCheckUncheck());
                indeterminate.bindBidirectional(a.getCheck().getIndeterminate());


                checkUncheck.addListener(new ChangeListener<Boolean>(){
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                        a.getCheck().indeterminateProperty().set(false);
                        a.getCheck().checkUncheckProperty().set(newValue);
                    }

                });
                indeterminate.addListener(new ChangeListener<Boolean>(){
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                            a.getCheck().indeterminateProperty().set(newValue);

                    }
                });
                if(indeterminate.get()){

                return null;
                }else{

                    return checkUncheck;
                }

            }
        });


        checks.setCellFactory(new Callback<TreeTableColumn<A, Boolean>, TreeTableCell<A, Boolean>>() {
            @Override
            public TreeTableCell<A, Boolean> call(TreeTableColumn<A, Boolean> param) {
                return new ThreeStateCheckBoxTreeTableCell(param);
            }
        });


        //building the tree;
        TreeItem<A> a1item=new TreeItem<>(a1);
        TreeItem<A> b11item=new TreeItem<>(b11);
        TreeItem<A> b12item=new TreeItem<>(b12);
        a1item.getChildren().add(b11item);
        a1item.getChildren().add(b12item);

        TreeItem<A> a2item=new TreeItem<>(a2);
        TreeItem<A> b21item=new TreeItem<>(b21);
        TreeItem<A> b22item=new TreeItem<>(b22);
        a2item.getChildren().add(b21item);
        a2item.getChildren().add(b22item);




        TreeItem<A> root=new TreeItem<>();
        root.getChildren().add(a1item);
        root.getChildren().add(a2item);

        treetable.getColumns().addAll(name,checks);

        treetable.setRoot(root);
        treetable.setShowRoot(false);
        treetable.setEditable(true);


      //  StackPane rootSp = new StackPane();
        Scene scene = new Scene(treetable, 300, 250);

        primaryStage.setTitle("CheckBoxTreeTable Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }




}