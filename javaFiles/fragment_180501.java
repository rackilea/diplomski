import java.util.List;

    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.ListView;

    public class TempCLV extends Activity {

private MySQLiteDefinitionHelper db;
String tblName = "";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.custom_listview_main);

    Intent msjIntent = getIntent();
    tblName = msjIntent.getStringExtra(WordDefinitionHomeActivity.TABLENAME2);
    refresh();
    }

    public void refresh()
    {
    db = new MySQLiteDefinitionHelper(this);
    final List<DefinitionObject> values = db.getAllWords(tblName);

    ListView mylist = (ListView)findViewById(R.id.customListView);
    MyPerformanceArrayAdapter adapter = new MyPerformanceArrayAdapter(this, R.id.customListView, values);
    mylist.setAdapter(adapter);
    }
    }