import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    new MyAsyncFileReader().execute("http://www.example.com/my/website/directory/thefile.txt");

}

public static class MyAsyncFileReader extends AsyncTask<String, Void,String []>
{

    @Override
    protected String [] doInBackground(String... params){
        String url= params[0];
        List<String> lines = new ArrayList<String>();
        try{
            URL u= new URL(url);

            HttpURLConnection conn= (HttpURLConnection) u.openConnection();
            InputStream is= conn.getInputStream();

            BufferedReader br =new BufferedReader(new      InputStreamReader(is));
            String line=null;
            while((line=br.readLine())!=null){
                lines.add(line);

            }
            br.close();
        }catch(Exception e){

        }
        return lines.toArray(new String[lines.size()]);

    }

    @Override
    protected void onPostExecute(String[] strings) {
        //You will get your string array result here .
        // do whatever operations you want to do

         for(int i=0;i<strings.length;i++){
            Log.e("LOG", strings[i]);
        }
    }

}

}