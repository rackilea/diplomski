import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity{
ProgressDialog pd;




@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
      pd = new ProgressDialog(this);
    pd.setTitle(getString("Title"));
    pd.setIndeterminate(true);
   pd.show();
    new MyAsycnTask().execute();

    }
}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}

private class MyAsycnTask extends AsyncTask <Void,Void,Void> {


    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        pd.hide();




    }
}
}