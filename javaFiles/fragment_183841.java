public class SomeClass{
    SomeClassController ctrl = new SomeClassController();
    Button continueButton = new Button("Continue");
    continueButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            ctrl.someMethod();
        }
    });
}