public class CountdownTextTickEventArgs {

    public String TimeString = "";
    public boolean isStopped = false;

    public CountdownTextTickEventArgs(int seconds, boolean isStoppedState) {
        TimeString = String.format("%02d:%02d",seconds/60, seconds % 60);
        isStopped = isStoppedState;
    }

}