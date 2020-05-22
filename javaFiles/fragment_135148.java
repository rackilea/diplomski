import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.root.myapplication.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    @TargetApi(23)
    protected void askPermissions() {
        String[] permissions = {
                "android.permission.INTERNET"
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);
    }

    public void changeText (View v){

        final TextView t1 = (TextView)findViewById(R.id.t1);

        new AsyncTask<Void,Void,Void>(){
            private Exception exception;
            private StringBuilder sb;
            @Override
            protected Void doInBackground(Void... voids) {
                try{
                    sb = new StringBuilder();
                    URL url;
                    HttpURLConnection con;
                    url= new URL("http://peyvandha.ir");
                    con= (HttpURLConnection) url.openConnection();
                    BufferedInputStream in = new BufferedInputStream(con.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    String Line = "";
                    while((Line = reader.readLine()) != null){
                        sb.append(Line);
                    }
                    in.close();
                }catch (Exception ex){
                    this.exception=ex;
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if(sb!=null){
                    //do what you do;
                    t1.setText(sb.toString());
                }else {
                    t1.setText(exception.getMessage());
                }
                super.onPostExecute(aVoid);
            }
        }.execute();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>22)askPermissions();

    }
}