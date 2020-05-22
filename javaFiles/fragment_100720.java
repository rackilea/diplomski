public class CommandFactory
{

    //The necessary processing goes here
    public Command create(SomeObjectA typeA){
         Command firstCommand = new Step1Command(typeA);
         Command secondCommand = new Step2Command(typeA);
         //....
         Command lastCommand = new StepXCommand(typeA);
         //We can easily switch the order of processing for a particular object
         fistCommand.setNext(secondCommand)
                    //...
                    .setNext(lastCommand);

         return firstCommand;
    }
}