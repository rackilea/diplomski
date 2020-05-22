package net.saband.myapp;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;
import net.saband.myapp.ServiceMyservice;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String package_root = context.getFilesDir().getAbsolutePath();
        String app_root =  package_root + "/app";
        Intent ix = new Intent(context, ServiceMyservice.class);
        ix.putExtra("androidPrivate", package_root);
        ix.putExtra("androidArgument", app_root);
        ix.putExtra("serviceEntrypoint", "./service/main.py");
        ix.putExtra("pythonName", "myservice");
        ix.putExtra("pythonHome", app_root);
        ix.putExtra("pythonPath", package_root);
        ix.putExtra("pythonServiceArgument", app_root+":"+app_root+"/lib");
        ix.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startService(ix);
    }
}