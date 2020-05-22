public class SomeClass{
    SomeClassController ctrl = new SomeClassController();
    private SomeClassController controller;
    Button continueButton = new Button("Continue");
    continueButton.setOnAction(ctrl.getHandler());
}

public class SomeClassController{

   private EventHandler<ActionEvent> EH;

   public SomeClassController(){
       EH = new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
              someMethod();
           }
       });
}

public EventHandler<ActionEvent> getHandler(){
return EH;
}

public void someMethod(){
//DO SOMETHING
}
}