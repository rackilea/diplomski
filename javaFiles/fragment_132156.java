import android.app.Activity;

 import android.content.Intent;

 import android.content.SharedPreferences;

 import android.content.SharedPreferences.Editor;

 import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

 import android.os.Bundle;

 import android.preference.PreferenceManager;

 import android.view.View;

 import android.widget.Button;

 import android.widget.EditText;


public class WorldCreator extends Activity{
EditText worldNameEditor;
Button saver;
SharedPreferences prefs;
OnSharedPreferenceChangeListener listener;
String updater;
Editor editor;

@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_worldcreator);
    prefs = PreferenceManager.getDefaultSharedPreferences(this);
    worldNameEditor = (EditText) findViewById(R.id.hello);
    saver = (Button) findViewById(R.id.button1);
    updater = worldNameEditor.getText().toString() + ",";

saver.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
           editor = prefs.edit();
           editor.putString("worldString", updater);   
           editor.commit();
           finish();
    }});

    }