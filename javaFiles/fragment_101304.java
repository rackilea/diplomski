import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

String[] MY_PERMISSIONS={
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA,
        Manifest.permission.ACCESS_FINE_LOCATION,
};
ArrayList<Integer> deniedPermissionPosition=new ArrayList<>();
String[] AGAINPERMISSIONS;
boolean firstTime=true;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    requestPermission(firstTime);
}
@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull final int[] grantResults) {

    switch (requestCode) {
        case 0: {
            boolean anyPermissionDenied = false;
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    anyPermissionDenied = true;
                    firstTime=false;
                    deniedPermissionPosition.add(i);
                }
            }
            if (!anyPermissionDenied)
            {
                getConfigFromServer();
            } else {
                Log.e("DEBUG","Permission Denied");
                String message = "";
                    message = "You have to give all permission to continue";
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                    alertDialogBuilder.setMessage(message);
                    alertDialogBuilder.setPositiveButton("yes",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    requestPermission(firstTime);
                                }
                            });

                    alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
            }
        }
        break;
        default:
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


}
void requestPermission(boolean firstTime) {
    if(firstTime){

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, MY_PERMISSIONS, 0);
        } else {

            getConfigFromServer();
        }
    }else {
        AGAINPERMISSIONS=new String[deniedPermissionPosition.size()];
        for (int permissions = 0; permissions < deniedPermissionPosition.size(); permissions++) {
            AGAINPERMISSIONS[permissions]=MY_PERMISSIONS[deniedPermissionPosition.get(permissions)];
        }
        ActivityCompat.requestPermissions(this, AGAINPERMISSIONS, 0);
    }
}

private void getConfigFromServer() {
    Log.e("DEBUG","Method call");
}
}