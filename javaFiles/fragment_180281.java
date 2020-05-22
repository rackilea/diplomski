public class Controls extends JPanel {
    private ReverseText reverseText; //the Event handler
    private TextFrame theTextFrame;  // the main frame to display the text

    // **** note changes to constructor
    public Controls(ReverseText reverseText, TextFrame theTextFrame){
        this.reverseText = reverseText;
        this.theTextFrame = textFrame;  // ***** added

        reverseText = new ReverseText(theTextFrame);