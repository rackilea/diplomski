package com.mycompany.yetanothercheckbox;

import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author returncode13
 */
   //to render checkboxes in treetable


    public  class ThreeStateCheckBoxTreeTableCell extends TreeTableCell<A, Boolean> {


        A selectedItem;
        CheckBox checkbox;
        TreeTableColumn<A,Boolean> param;
        /*private static boolean updateParent=false;
        private static boolean updateChildren=false;*/


        public ThreeStateCheckBoxTreeTableCell(TreeTableColumn<A,Boolean> param) {
            checkbox=new CheckBox();
            this.param=param;
            checkbox.setAllowIndeterminate(true);

            checkbox.selectedProperty().addListener((obs,wasSelected,isNowSelected) -> {
               int sel=getTreeTableRow().getIndex();
               selectedItem=this.param.getTreeTableView().getSelectionModel().getModelItem(sel).getValue();
               selectedItem.getCheck().getCheckUncheck().set(isNowSelected);
               selectedItem.getCheck().getIndeterminate().set(false); 

              //ThreeStateCheckBoxTreeTableCell.this.param.getTreeTableView().refresh();


            });


            checkbox.indeterminateProperty().addListener((obx,ol,newV)->{

               int sel=getTreeTableRow().getIndex();
               selectedItem=this.param.getTreeTableView().getSelectionModel().getModelItem(sel).getValue();
                selectedItem.getCheck().getIndeterminate().set(newV);

           //ThreeStateCheckBoxTreeTableCell.this.param.getTreeTableView().refresh();
            });



            checkbox.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    int sel=getTreeTableRow().getIndex();
                    selectedItem=ThreeStateCheckBoxTreeTableCell.this.param.getTreeTableView().getSelectionModel().getModelItem(sel).getValue();
                    if(selectedItem.isParent()){

                        selectedItem.updateChildren=true;
                        for(A child:selectedItem.getChildren()){
                            child.updateParent=false;
                        }


                         updateDownwards();
                    }
                    if(selectedItem.isLeaf()){

                        selectedItem.getParent().updateChildren=false;
                        selectedItem.updateParent=true;

                        updateUpWards();
                    }

                    ThreeStateCheckBoxTreeTableCell.this.param.getTreeTableView().refresh();
                }

            });
        }


        @Override
        public void updateItem(Boolean b,boolean empty){
            super.updateItem(b, empty);

            if(empty){
                setGraphic(null);
            }else{


                if(b==null){
                    checkbox.setIndeterminate(true);

                }
                else{
                    checkbox.setIndeterminate(false);
                    checkbox.setSelected(b);

                }
               setGraphic(checkbox);

            }

            ThreeStateCheckBoxTreeTableCell.this.param.getTreeTableView().refresh();
        }

        private void updateUpWards(){

            if(selectedItem.updateParent){


            List<A> children=selectedItem.getChildren();
            int indeterminateCount=0;
            int selectedCount=0;

                A parent=selectedItem.getParent();
                for(A child:children){
                    indeterminateCount+=child.getCheck().getIndeterminate().get()?1:0;
                    selectedCount+=child.getCheck().getCheckUncheck().get()?1:0;

                }

                if(indeterminateCount>0) {

                     parent.getCheck().getIndeterminate().set(true);
                }
                else if(indeterminateCount==0 && selectedCount==children.size()){
                    parent.getCheck().getIndeterminate().set(false);
                    parent.getCheck().getCheckUncheck().set(true);
                }else{

                    parent.getCheck().getIndeterminate().set(false);
                    parent.getCheck().getCheckUncheck().set(false);
                }

            }
            ThreeStateCheckBoxTreeTableCell.this.param.getTreeTableView().refresh();


        }


        private void updateDownwards(){
             List<A> children=selectedItem.getChildren();

             if(selectedItem.isParent() && selectedItem.updateChildren ){

                 for(A child:children){
                   child.getCheck().getCheckUncheck().set(selectedItem.getCheck().getCheckUncheck().get());

                  child.getCheck().getIndeterminate().set(selectedItem.getCheck().getIndeterminate().get());
                }


             }
             ThreeStateCheckBoxTreeTableCell.this.param.getTreeTableView().refresh();

        }
    }