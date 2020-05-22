import javax.swing.Timer;

...

private Timer t; //declare "global" timer (needs to bee seen from multiple methods)

private void init() {

    t = new Timer(2000, putYourUsefullActionListenerHere);
    //the one that will acctually do something after two seconds of no change in your field

    t.setRepeats(false); // timer fires only one event and then stops
}

private void onTextFieldChange() { //call this whenever the text field is changed
    t.restart();
    //dont worry about "restart" and no start, it will just stop and then start
    //so if the timer wasnt running, restart is same as start
}

private void terminate() {
    //if you want for any reson to interrupt/end the 2 seconds colldown prematurelly
    //this will not fire the event
    t.stop();
}