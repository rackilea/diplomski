public class YourJProgressBar extends JProgressBar {

    public YourJProgressBar() {
        super();
    }

    {
        // Whatever code you want in here, will run immediately after the call
        // to 'super' in any given constructor.  Note, in cases where the call
        // to 'super' is implicit, it will run after that implicit call
        // instead of just never running.
        this.setValue(10);
    }
}