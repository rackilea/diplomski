****I solved it****
package deneme.json.jsondeneme;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


    public class MainActivity extends AppCompatActivity {

    TextView text;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         button = (Button) findViewById(R.id.button);
        text= (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new arkaPlan().execute();

            }
        });
    }

    protected class arkaPlan extends AsyncTask<Void,Void,Void>{
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line,result= "";
        @Override
        protected Void doInBackground(Void... voids) {

            try {
                URL url = new URL("https://restcountries.eu/rest/v2/capital/tallinn");
                br = new BufferedReader(new InputStreamReader(url.openStream()));
                while((line = br.readLine())!= null){
                    sb.append(line).append("\n");
                }
                result = sb.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            text.setText(result);
            super.onPostExecute(aVoid);
        }
    }

    }