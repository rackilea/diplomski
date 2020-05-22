public class Step1Command extends BaseCommand
{
    // If we need access to the SomeObject instance we can define a dependecy on it
    // ex. through a constructor

    //The necessary processing goes here
    public void executeImpl(){
         doStep1();
    }
}