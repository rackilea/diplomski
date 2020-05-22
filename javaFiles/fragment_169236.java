package it.versionestabile.stackover001;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

/**
 * https://stackoverflow.com/questions/48500077/recognizerintent-action-get-language-details-in-oreo
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent vrIntent = new Intent(RecognizerIntent.ACTION_GET_LANGUAGE_DETAILS);
        vrIntent.setPackage("com.google.android.googlequicksearchbox");

        PackageManager packageManager = getPackageManager();

        for (PackageInfo packageInfo: packageManager.getInstalledPackages(0)) {
            if (packageInfo.packageName.contains("com.google.android.googlequicksearchbox"))
                Log.d("AAA", packageInfo.packageName + ", "  + packageInfo.versionName);
        }

        this.sendOrderedBroadcast(vrIntent, null, new BroadcastReceiver() {

            @Override
            public void onReceive(final Context context, final Intent intent) {

                // final Bundle bundle = intent.getExtras();
                final Bundle bundle = getResultExtras(true);

                if (bundle != null) {

                    if (bundle.containsKey(RecognizerIntent.EXTRA_SUPPORTED_LANGUAGES)) {
                        Log.i("TAG", "onReceive: EXTRA_SUPPORTED_LANGUAGES present");

                        final ArrayList<String> vrStringLocales = bundle.getStringArrayList(
                                RecognizerIntent.EXTRA_SUPPORTED_LANGUAGES);

                        Log.i("TAG", "onReceive: EXTRA_SUPPORTED_LANGUAGES size: " + vrStringLocales.size());

                    } else {
                        Log.w("TAG", "onReceive: missing EXTRA_SUPPORTED_LANGUAGES");
                    }

                } else {
                    Log.w("TAG", "onReceive: Bundle null");
                }
            }

            }, null, 1234, null, null);
    }
}