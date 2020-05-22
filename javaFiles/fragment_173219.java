import android.os.BatteryManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
private TextView batteryPercent;
private void getBatteryPercentage() {
BroadcastReceiver batteryLevelReceiver = new BroadcastReceiver() {
     public void onReceive(Context context, Intent intent) {
         context.unregisterReceiver(this);
         int currentLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
         int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
         int level = -1;
         if (currentLevel >= 0 && scale > 0) {
             level = (currentLevel * 100) / scale;
         }
         batteryPercent.setText("Battery Level Remaining: " + level + "%");
     }
 }; 
 IntentFilter batteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
 registerReceiver(batteryLevelReceiver, batteryLevelFilter);
}

/* @Override*/
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     batteryPercent = (TextView) this.findViewById(R.id.textview);
     getBatteryPercentage();
}

//    @Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
}

}