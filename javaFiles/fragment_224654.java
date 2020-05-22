package android.application.project.planes;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivityPlanes extends Activity {

    Button Add;
    ListView List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_activity_planes);

        Add = (Button) findViewById(R.id.button1);
        List = (ListView) findViewById(R.id.listView1);

        List.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {
                // TODO Auto-generated method stub
                Intent launchActivity = new Intent(MainActivityPlanes.this,
                        MainActivityPaper.class);
                startActivity(launchActivity);
            }
        });

        Add.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        MainActivityPaper.class);
                startActivityForResult(intent, 0);
            }
        });

        MainActivityChampagne info = new MainActivityChampagne(this);
        info.open();
        ArrayList<String> data = info.getData();
        info.close();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data);
        List.setAdapter(arrayAdapter);

    }

}