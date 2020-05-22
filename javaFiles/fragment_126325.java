import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import java.io.*;

public class FileDemo1 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try {
            playWithRawFiles();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Problems: " + e.getMessage(), 1).show();
        }
    }

    public void playWithRawFiles() throws IOException {      
        String str = "";
        StringBuffer buf = new StringBuffer();            
        InputStream is = this.getResources().openRawResource(R.drawable.my_base_data);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            if (is != null) {                            
                while ((str = reader.readLine()) != null) {    
                    buf.append(str + "\n" );
                }                
            }
        } finally {
            try { is.close(); } catch (Throwable ignore) {}
        }
        Toast.makeText(getBaseContext(), buf.toString(), Toast.LENGTH_LONG).show();
    }
}