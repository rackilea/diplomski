package com.example.searchtest;

import java.util.ArrayList;
import java.util.List;

import com.parse.*;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private Button search;
    private EditText searchArea;
    private ListView userList;
    //private String uName;
    private ArrayAdapter<ParseUser> mainAdapter;
    private ArrayList<ParseUser> resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, "WHz2GmkGFIUxBir6ZEDt2FIG4WUcE1kfKZmPayxy", "IAs1RCaRt5LM1E1ZW7LFXy5uDjtZEQ5CDa3LKJt2");

        setContentView(R.layout.activity_main);


        search = (Button) findViewById(R.id.searchButton);
        searchArea = (EditText) findViewById(R.id.searchField);
        userList = (ListView) findViewById(R.id.userResultList);
        resultList = new ArrayList<ParseUser>();
        mainAdapter = new ArrayAdapter<ParseUser>(this, R.layout.list_item, R.id.user_results,resultList);
        //mainAdapter.setTextKey("username");

        //userList.setAdapter(mainAdapter);
        //mainAdapter.loadObjects();



        search.setOnClickListener(new OnClickListener() {



            @Override
            public void onClick(View v) {

                final String uName = searchArea.getText().toString();

                final ParseQuery<ParseUser> query = ParseUser.getQuery();
                query.whereEqualTo("username", uName);

                query.findInBackground(new FindCallback<ParseUser>() {
                  public void done(List<ParseUser> objects, ParseException e) {
                    if (e == null) {

                           for(int i=0; i<objects.size();i++)
                            {
                                resultList.add((ParseUser)objects.get(i));
                            }
                           userList.setAdapter(mainAdapter);

                        Toast.makeText(getApplicationContext(), "User is Found",
                                Toast.LENGTH_LONG).show();

                    } else {
                        // Something went wrong.
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "User is not Found",
                                Toast.LENGTH_LONG).show();
                    }
                  }
                });

                userList.setAdapter(mainAdapter);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}