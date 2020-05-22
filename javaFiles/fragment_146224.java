public class UIController {
    private final MainClass mainClass;
    UIController (final MainClass mainClass) {
         this.mainClass = mainClass;
         //Call a method in MainClass here, for example MethodIWantToCall()
         this.mainClass.MethodIWantToCall();
    }

    public void MethodA() {
        //Call a method in MainClass here, for example MethodIWantToCall()
         this.mainClass.MethodIWantToCall();             
    }
}