package at.co.ccc.mondel;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;

public class StartingPoint extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Spinner spinner = (Spinner) findViewById(R.id.comboCasino);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.comboCasino, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        // this will be called when you select any item in this spinner
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long arg3) {
                // get the text at that position
                String Text = spinner.getSelectedItem().toString();
                // if Text is equals to "Wien Simmering"
                if(Text.equals("Wien Simmering")) {
                    // start a new activity
                    // here StartingPoint.this is context
                    // and simmering.class is the next activity going to be opened
                    Intent NewPost = new Intent(StartingPoint.this,Simmering.class);
                    startActivity(NewPost);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        } ); // i forget to add ); here that is why it was giving multiple markers error
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    // action with ID action_refresh was selected
    case R.id.action_refresh:
    Toast.makeText(this, R.string.refreshed, Toast.LENGTH_SHORT).show();
    break;
    // action with ID action_settings was selected
    case R.id.action_settings:
    Toast.makeText(this, R.string.settings_clicked, Toast.LENGTH_SHORT).show();
    break;
    default:
    break;
    }
    return true;
    } 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.starting_point, menu);
        return true;
    }

}