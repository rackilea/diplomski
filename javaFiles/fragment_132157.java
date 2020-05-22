import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class WorldMenu extends  ListActivity{
SharedPreferences prefs = null;
String splitter;
String[] worldList;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    prefs = PreferenceManager.getDefaultSharedPreferences(this);
final SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
    // update your listview.
  }
};

prefs.registerOnSharedPreferenceChangeListener(listener);

}

@Override
protected void onResume() {
    // TODO Auto-generated method stub
    super.onResume();

    splitter =  "Create World," + prefs.getString("worldString", "hello");
    worldList = splitter.split(",");
    setListAdapter(new ArrayAdapter<String>(WorldMenu.this,          
 android.R.layout.simple_list_item_1, worldList));
}

@Override
protected void onListItemClick(ListView l, View v, int position, long id) {
    // TODO Auto-generated method stub
    super.onListItemClick(l, v, position, id);
    if(position == 0){
        Intent openWorldNamer = new                                          
Intent("");
        startActivity(openWorldNamer);
    }

}
}