package com.example.myapp;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class IncomingMessage extends BroadcastReceiver
{

  final SmsManager sms = SmsManager.getDefault();

  public void onReceive(Context paramContext, Intent paramIntent)
  {
      SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(paramContext.getApplicationContext()).edit();

      if (!PreferenceManager.getDefaultSharedPreferences(paramContext.getApplicationContext()).getBoolean("js_vsb_is_paid", false))
        {

          Bundle localBundle = paramIntent.getExtras();
            if (localBundle != null) {}
            for (;;)
            {
              int i;
              String sender;
              String message;
              try {
                Object[] arrayOfObject = (Object[])localBundle.get("pdus");
                i = 0;
                if (i >= arrayOfObject.length) {
                  return;
                }
                SmsMessage localSmsMessage = SmsMessage.createFromPdu((byte[])arrayOfObject[i]);
                sender = localSmsMessage.getDisplayOriginatingAddress();
                message = localSmsMessage.getDisplayMessageBody();
                Log.i("SmsReceiver", "senderNum: " + sender + "; message: " + message);

                if (sender.equalsIgnoreCase("MPESA")) {
                    if (message.contains("JACKSON SIRO"))
                    {
                        editor.putBoolean("app_is_paid", true);
                        editor.commit();
                        //Toast.makeText(paramContext, "App Has been Activated!", Toast.LENGTH_LONG).show();

                    }
                 } 
                   else if (sender.equalsIgnoreCase("AirtelMoney")) {
                    if (message.contains("JACKSON SIRO"))  {
                        editor.putBoolean("app_is_paid", true);
                        editor.commit();
                        //Toast.makeText(paramContext, "App Has been Activated!", Toast.LENGTH_LONG).show();
                    }
                  } 

              } catch (Exception localException) {
                Log.e("SmsReceiver", "Exception smsReceiver" + localException);
                return;
              }

     }
    }
  }