package com.example.androidcontacts;



import android.app.ListActivity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {

    ListView mylist;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri allContacts = Uri.parse("content://"+"com.example.androidcontacts.Books" + "/Contact");

        Cursor c;
        CursorLoader cursorLoader = new CursorLoader(
        this,allContacts,null,null,null,null);
        c = cursorLoader.loadInBackground();

        String[] columns = new String[] {Contact._ID,Contact.TITLE,Contact.AUTHOR,Contact.YEAR,Contact.IMAGE};

        int[] views = new int[] {R.id.contactID,R.id.contactName,R.id.contactAuthor,R.id.contactYear,R.id.Image};

        SimpleCursorAdapter adapter;
        adapter = new SimpleCursorAdapter(this, R.layout.activity_main, 
                c, columns, views,CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        this.setListAdapter(adapter); 
        }





     @Override
     protected void onListItemClick(ListView list, View view, int position, long id) {

         //Intent i=new Intent(MainActivity.this,Details.class);
         //startActivity(i);
 }

     @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.main, menu);
              return true;
     }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if(id == R.id.action_search){
            Intent intent = new Intent(this, Search.class);
            startActivity(intent);
            finish();
            return true;
        }

        if(id == R.id.action_add){
            Intent intent = new Intent(this, Add.class);
            startActivity(intent);
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



}