package co.introtuce.nex2me.writefle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    public static final int WRITE_PERMISSION=0xff;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.mid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
            }
        });
    }

    public void requestPermission(){
        if(!checkPermission()){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        WRITE_PERMISSION);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }

        }
        else {
            afterPermisiion();
        }
    }
    public boolean checkPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED){
            return false;
        }
        return true;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == WRITE_PERMISSION){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //Permisiion Granted
                afterPermisiion();
                return;
            }

        }
        requestPermission();

    }

    public void afterPermisiion(){
        submit();
    }

    public boolean saveFile(String csv_contents, Context context){
        OutputStream outputStream = null;
        try{
            File root = Environment.getExternalStorageDirectory();
            if(root == null){
                Log.d("SAVE_PHONE", "Failed to get root");
                return false;
            }

            // create a directory
            File saveDirectory = new File(root,"appName/files/csv" );
            // create direcotory if it doesn't exists

            // create direcotory if it doesn't exists
            if(!saveDirectory.exists()) if ( !saveDirectory.mkdirs()){
                Toast.makeText(context,"sorry could not create directory"+saveDirectory.getAbsolutePath(), Toast.LENGTH_LONG).show();
                return false;
            }

            outputStream = new FileOutputStream( saveDirectory + "myfile.csv"); // filename.png, .mp3, .mp4 ...
            if(outputStream != null){
                Log.e( "SAVE_PHONE", "Output Stream Opened successfully");
            }

            byte[] bytes = csv_contents.getBytes();
            outputStream.write( bytes, 0, bytes.length );
            outputStream.close();
            return true;

        }catch (Exception e){
            Log.d("EXCEPTION_IN",e.toString());
            return false;
        }

    }
    public void submit()
    {
        String nline = System.getProperty("line.separator");
        String fname = "Name" + ",";
        String sname = "Surname" + ",";
        String gender = "gn" + ",";
        String eaddress = "email" + ",";
        String mnum = "num" + ",";
        String fos = "fos" + ",";
        String prole = "prole";
        FileOutputStream file = null;

        if(fname.length() <= 1 || sname.length() <= 1 || eaddress.length() <= 1){
            Toast.makeText(this, "Please enter all mandatory fields", Toast.LENGTH_SHORT).show();
        }

        String csv_contents = nline+""+fname+sname+gender+eaddress+mnum+fos+prole;
        if(saveFile(csv_contents,this)){
            //File has saved
            // DO something
            Toast.makeText(this,"File has been saved",Toast.LENGTH_LONG).show();
        }
        else{
            //Could not save file
            // DO something
        }
    }

}