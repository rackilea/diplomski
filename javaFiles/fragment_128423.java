package xyz.selfenrichment.robertotomas.jsonparsing_stackoverflow;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView Titre, Auteur, Categorie , Editeur , Prix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Titre = (TextView) findViewById(R.id.titreTextView);
        Auteur = (TextView) findViewById(R.id.auteurTextView);
        Categorie = (TextView) findViewById(R.id.categorieTextView);
        Editeur = (TextView) findViewById(R.id.editeurTextView);
        Prix = (TextView) findViewById(R.id.prixTextView);
        new getData().execute();
    }

    class getData extends AsyncTask<String, String, String> {
        private String LOCALHOST = "192.168.1.9";
        HttpURLConnection urlConnection = null;

        @Override
        protected String doInBackground(String... args) {
            StringBuilder result = new StringBuilder();
            try {
                URL url = new URL("http://"+LOCALHOST+":8000/api/liste.json");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");

                urlConnection.setDoOutput(true);

                urlConnection.connect();

                BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));

                char[] buffer = new char[1024];

                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line+"\n");
                }
                br.close();

                String jsonString = result.toString();

                System.out.println("JSON: " + jsonString);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }

            return result.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                JSONArray jsonArray = new JSONArray(result);
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                String t = jsonObject.getString("Titre");
                String a = jsonObject.getString("Auteur");
                String c = jsonObject.getString("Categorie");
                String e = jsonObject.getString("Editeur");
                String p = jsonObject.getString("Prix");
                Titre.setText(t);
                Auteur.setText(a);
                Categorie.setText(c);
                Editeur.setText(e);
                Prix.setText(p);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}