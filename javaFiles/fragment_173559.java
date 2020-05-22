class MyConsole extends IOConsole {
 private IOConsoleInputStream fInput;
 private IOConsoleOutputStream fOutput;
 private IStreamsProxy fStreamsProxy;
 private ConsoleHistory history;
 //This is to remember the caret position after the prompt 
 private int caretAtPrompt;
     /* in the console so when you need to replace the command on up and down 
      * arrow keys you have the position. 
      * I just did a caretAtPrompt += String.Length wherever string was 
      * appended to the console. Mainly in the streamlistener and 
      * InputJob unless you specifically output something to the output 
      * stream.
      */
 //In the constructor you assign all the above fields. Below are some 
 //to point out.
 //fInput = getInputStream();
 // fStreamsProxy = process.getStreamsProxy();
 // fOutput = newOutputStream();

 //We must override the following method to get access to the caret
 @Override
 public IPageBookViewPage createPage(IConsoleView view) {
    return new MyConsolePage(this, view);
    }
 //After this I followed the ProcessConsole and added the 
 //InputJob and StreamListener
 //defined in there. 
 }

class MyConsolePage extends TextConsolePage {
 //Not much in this class, just override the createViewer
 // to return MyConsoleViewer
 }

class MyConsoleViewer extends TextConsoleViewer {
 //This is the most important class and most of the work is done here
 //Again I basically copied everything from IOConsoleViewer and then
 //updated whatever I needed
 //I added a VerifyKeyListener for the up and down arrow 
 //keys for the console history

 MyConsoleViewer (Composite parent, MyConsole console) {
  //I have omitted a lot of code as it was too much to put up, 
  //just highlighted a few
  getTextWidget().addVerifyKeyListener(new MyKeyChecker());
  }

 class MyKeyChecker implements VerifyKeyListener {...}

 }