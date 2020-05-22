package net.example.app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.example.app.MyObject;
import net.example.app.MyObject_ListAdapter;

import java.util.ArrayList;

public class MyActivity extends AppCompatActivity {

    private ArrayAdapter arrayAdapter;
    private ArrayList<MyObject> myObjects = new ArrayList<>();

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myactivity);

        db = openOrCreateDatabase("database.db", MODE_PRIVATE, null);

        ListView lv = (ListView) findViewById(R.id.lv);
        arrayAdapter = new MyObject_ListAdapter(this, myObjects); //Define the custom list adapter with the activity and arraylist
        lv.setAdapter(arrayAdapter); //Connect your listview with the adapter

        displayData();
    }

    private void displayData() {
        Cursor c = db.rawQuery("SELECT * FROM my_table", null);
        while (c.moveToNext()) { //Loop through all the records
            //Now on the variable 'c' there is one record.

            int column_a_name = c.getColumnIndex("my_column1"); //Get the index of the column from your table.
            String column_a_value = c.getString(column_a_name); //Get the value from the column from the current record.

            int column_b_name = c.getColumnIndex("my_column2");
            String column_b_value = c.getString(column_b_name);

            //Now you can do with the value what you want.
            myObjects.add(new MyObject(column_a_value, column_b_value));

        }

        arrayAdapter.notifyDataSetChanged(); //Notify, that you have changed some data in the array list.
    }
}