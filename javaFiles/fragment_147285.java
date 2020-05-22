public class Foo extends Application{
  @Override
  public void start(Stage primaryStage) throws IOException{
    ToggleGroup group = new ToggleGroup();

    ToggleButton tb1 = new ToggleButton("ToggleButton 1");
    ToggleButton tb2 = new ToggleButton("ToggleButton 2");
    ToggleButton tb3 = new ToggleButton("ToggleButton 3");

    tb1.setToggleGroup(group);
    tb2.setToggleGroup(group);
    tb3.setToggleGroup(group);

    Button btn = new Button("GO");
    btn.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event){
        Toggle selectedTogger = group.getSelectedToggle();
        if(selectedTogger == tb1){
          //outcome 1 (ToggleButton1 selected)

        }else if(selectedTogger == tb2){
          //outcome 2 (ToggleButton2 selected)

        }else if(selectedTogger == tb3){
          //outcome 3 (ToggleButton3 selected)

        }else{
          //outcome 4 (No ToggleButton selected)

        }
      }
    });

    VBox vbox = new VBox();
    vbox.getChildren().addAll(tb1, tb2, tb3, btn);

    primaryStage.setScene(new Scene(vbox));
    primaryStage.show();
  }

  public static void main(String[] args){
    launch(args);
  }
}