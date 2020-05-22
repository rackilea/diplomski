package com.android.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class DemoListSpinnerActivity extends Activity {
    ListView _listview;
    String[] itemsarray=new String[]{"one","two","three"};
    ArrayAdapter<String> adapter;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,itemsarray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _listview=(ListView)findViewById(R.id.listView1);
        _listview.setAdapter(new CustomAdapter(this));

    }

    private class CustomAdapter extends BaseAdapter
    {
        LayoutInflater inflater;
        public CustomAdapter(Context  context)
        {
            inflater=LayoutInflater.from(context);
        }

        public int getCount() {
            // TODO Auto-generated method stub
            return 5;
        }

        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public View getView(int arg0, View convertview, ViewGroup arg2) {
            ViewHolder viewHolder;
            if(convertview==null)
            {
                convertview=inflater.inflate(R.layout.listrow,null);
                viewHolder=new ViewHolder();
                viewHolder.spinner=(Spinner)convertview.findViewById(R.id.spinner1);
                viewHolder.spinner.setAdapter(adapter);
                convertview.setTag(viewHolder);
            }
            else
            {
                viewHolder=(ViewHolder)convertview.getTag();
            }
            return convertview;
        }
        public class ViewHolder
        {
            Spinner spinner;
        }

    }
}
main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    >
<TextView  
    android:layout_width="fill_parent" 
    android:layout_height="wrap_content" 
    android:text="@string/hello"
    />
<ListView android:layout_height="wrap_content" android:id="@+id/listView1" android:layout_width="match_parent"></ListView>
</LinearLayout>
listrow.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
  xmlns:android="http://schemas.android.com/apk/res/android"
  android:orientation="vertical"
  android:layout_width="match_parent"
  android:layout_height="match_parent">
    <Spinner android:layout_height="wrap_content" android:layout_width="match_parent" android:id="@+id/spinner1"></Spinner>

</LinearLayout>