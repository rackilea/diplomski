public class ButtonActivity extends Activity {

    private Gpio mLedGpio;
    private ButtonInputDriver mButtonInputDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PeripheralManager pioService = new PeripheralManager.getInstance();
        try {
            mLedGpio = pioService.openGpio(BoardDefaults.getGPIOForLED());
            mLedGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);

            mButtonInputDriver = new ButtonInputDriver(
                    BoardDefaults.getGPIOForButton(),
                    Button.LogicState.PRESSED_WHEN_LOW,
                    KeyEvent.KEYCODE_SPACE);
            mButtonInputDriver.register();
        } catch (IOException e) {
            throw new IllegalStateException("Error configuring GPIO pins", e);
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_SPACE) {
            toggleLedValue();
            return true;
        }    
        return super.onKeyUp(keyCode, event);
    }

    /**
     * Update the value of the LED output.
     */
    private void toggleLedValue() {
        try {
            mLedGpio.setValue(!mLedGpio.getValue());
        } catch (IOException e) {
            Log.e(TAG, "Error updating GPIO value", e);
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        mButtonInputDriver.unregister();
        try {
            mButtonInputDriver.close();
        } catch (IOException e) {
            Log.e(TAG, "Error closing Button driver", e);
        }

        try {
           mLedGpio.close();
        } catch (IOException e) {
           Log.e(TAG, "Error closing LED GPIO", e);
        } 
   }  
}