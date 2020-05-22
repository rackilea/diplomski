package com.arrdude.forumanswer;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class TestResultActivity extends Activity implements OnClickListener {
    private static final int REQUEST_LIST_ITEM = 235; //arbitrary request code
    static final String ADAPTER_VALUE_1 = "head";
    static final String ADAPTER_VALUE_2 = "sub";

    ArrayList<HashMap<String, String>> masterlist = null;
    ListAdapter adapter = null;

    ListView listview = null;
    Button addbutton = null;

    public ListAdapter getAdapter() {
        if(adapter == null){
            adapter = new SimpleAdapter(this, getMylist(), R.layout.listitem, new String[] {ADAPTER_VALUE_1, ADAPTER_VALUE_2}, new int[] {R.id.listheading, R.id.listsubheading});
        }
        return adapter;
    }

    public ListView getListview() {
        if(listview==null){
            listview = (ListView) findViewById(R.id.mainlistview);
            listview.setAdapter(getAdapter());
        }
        return listview;
    }

    public Button getAddbutton() {
        if(addbutton==null){
            addbutton = (Button) findViewById(R.id.mainaddbutton);
            addbutton.setClickable(true);
            addbutton.setOnClickListener(this);
        }
        return addbutton;
    }

    public ArrayList<HashMap<String, String>> getMylist() {
        if(masterlist==null){
            masterlist = new ArrayList<HashMap<String,String>>();
        }
        return masterlist;
    }

    public void addListItem(String head, String sub){
        HashMap<String, String> addme=new HashMap<String, String>();
        addme.put(ADAPTER_VALUE_1, head);
        addme.put(ADAPTER_VALUE_2, sub);

        masterlist.add(addme);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //lazy init objects not the most efficient in Android but easier reading
        getListview();
        getAddbutton();
        addListItem("Test Head", "Test sub heading here below"); //an initial item for testing
    }

    @Override
    public void onClick(View v) {
        Intent launchadditemI = new Intent(this, AddItemActivity.class);
        startActivityForResult(launchadditemI, REQUEST_LIST_ITEM);
    }

    @Override
    public void onActivityResult(int req, int res, Intent data){
        if(req == REQUEST_LIST_ITEM && res == RESULT_OK){
            String thishead = data.getStringExtra(ADAPTER_VALUE_1);
            String thissub = data.getStringExtra(ADAPTER_VALUE_2);
            addListItem(thishead, thissub);
        }
    }
}