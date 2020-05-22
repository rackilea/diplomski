public class TestTimerTask implements WiimoteListener { 

    private Timer timer = new Timer();

    @Override
    public void onButtonsEvent(WiimoteButtonsEvent wbe) {

        if(wbe.isButtonAJustReleased()) {
            timer.cancel();
        }

        if(wbe.isButtonAJustPressed()) {
            timer.schedule(...);
        }

    }

}