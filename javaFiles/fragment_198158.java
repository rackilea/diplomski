import java.io.IOException;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import com.iPrint.iObject;
import com.iPrint.iPaperType;
import com.iPrint.iPrint;
import com.iPrint.iPrinters;
import com.iPrint.iSettings;
import com.iPrint.ipConnection;

public class MainActivity extends Activity {

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    iSettings set = new iSettings();
    set.SetPaperType(iPaperType.LETTER);
    set.PrinterType(iPrinters.HP);

    //Creating Connection object

    ipConnection wfc = new ipConnection();

    wfc.ipAddress("IP-Address");
    wfc.Port(port-number);
    try {
        wfc.Connect();
        Log.e("Connected",  wfc.isConnected()+"");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        Log.e("In Error", "In Error");
        e.printStackTrace();
    }

    //Creating a Printing object
    iPrint p = new iPrint(getApplicationContext()); 
    p.Connection(wfc);
    p.Settings(set);
    if (wfc.isConnected())
    {
        p.Start();
        iObject ob = new iObject();
        ob.Text("Hello iPrint!");
        p.Add(ob);
        p.End(); 
        p.Print(); 
        ob = null;
    }
    else
    {
        Log.v("Error",wfc.ErrorMessage()+"");
       //showDialog(wfc.ErrorMessage(), AppContext);
    }
    print(getApplicationContext());
}
private void print(Context AppContext) 
{ 
//Creating Settings object
iSettings set = new iSettings();
set.SetPaperType(iPaperType.LETTER);
set.PrinterType(iPrinters.HP);

//Creating Connection object

ipConnection wfc = new ipConnection();
wfc.ipAddress("ip-address");
wfc.Port(port-number);
try {
    wfc.Connect();
} catch (IOException e) {
    // TODO Auto-generated catch block
    Log.e("In Error", "In Error");
    e.printStackTrace();
}

//Creating a Printing object
iPrint p = new iPrint(AppContext); 
p.Connection(wfc);
p.Settings(set);
if (wfc.isConnected())
{
    p.Start();
    iObject ob = new iObject();
    ob.Text("Hello iPrint!");
    p.Add(ob);
    p.End(); 
    p.Print(); 
    ob = null;
}
else
{
    Log.v("Error",wfc.ErrorMessage()+"");
}
 set = null;
 wfc = null;
 p = null; 
 }
}