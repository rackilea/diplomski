package de.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class analyzer extends Activity implements OnClickListener{ 
    TextView dateAndTimeLabel;
    private Button closeButton; 
    private int signalDBM = 0;

         public class GetParams extends PhoneStateListener 
         {

             @Override  
             public void onSignalStrengthsChanged(SignalStrength signalStrength)
             {
                  super.onSignalStrengthsChanged(signalStrength);
                  signalDBM = signalStrength.getGsmSignalStrength();
             }
         }

         @Override
         public void onCreate(Bundle icicle) {
             super.onCreate(icicle);
             setContentView(R.layout.main);

             GetParams listener = new GetParams();
             TelephonyManager TelManager = ( TelephonyManager )getSystemService(Context.TELEPHONY_SERVICE);
             TelManager.listen(listener ,PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);

             Button btn=(Button)findViewById(R.id.start);
             btn.setOnClickListener(this);             
         }


            @Override
         public void onClick(View v) {
             switch (v.getId()) {
                    case R.id.start:
                         Toast.makeText(this, "GSM signal strength is " + this.signalDBM , Toast.LENGTH_SHORT).show();
                         break;                    
            }
        }        
}