public class YourActivity extends AppCompatActivity {

    ...

    private BlinkFragment getBlinkFragment() {
        return (BlinkFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int delay = 150; // delay 150 ms.

        switch (item.getItemId()){
            case R.id.action_disconnect:
                data.saveData(this.getApplicationContext());
                Disconnect();
                getBlinkFragment.onDisconnected();

                return true;
            case R.id.action_check:

                if (item.isChecked())
                {
                    // here i want to update button status
                    item.setChecked(false);
                    ledControl.instance.data.expertMode = false;
                    ledControl.instance.data.configExpertMode = 1;
                    ledControl.instance.data.sendConfigTurnLightMessage();
                }
                else {
                    item.setChecked(true);
                    ledControl.instance.data.expertMode = true;
                    // here i want to update button status
                }
                getBlinkFragment.onLedControlChanged(ledControl);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    ....
}