public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "I'm running", Toast.LENGTH_SHORT).show();
        int extra = intent.getExtra("Activity");
        switch(extra) {
              case 1:
                     //start 1st activity

              case 2:
                     //start 2nd activity

              case 3:
                     //start 3rd activity
        }

    }
}