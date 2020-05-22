import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    EditText userName;
    EditText password;
    Boolean verified = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        userName = (EditText) findViewById(R.id.userNameField);
        password = (EditText) findViewById(R.id.passwordField);
loginButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((userName.getText().toString() != "bkAdmin") || (password.getText().toString() != "midAmBK")) {
                    verified = false;
                } else {
                    verified = true;
                }

 SharedPreferences preferences = getSharedPreferences("config.xml", MODE_PRIVATE);
        if (verified) {
            Intent intent = new Intent(login.this, midamcorp.com.burgerkingapp.preferences.class);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("loggedIn", true);
            editor.commit();
            if (preferences.getBoolean("config", false)) {
                editor.putBoolean("config", true);
                editor.commit();
            }
            startActivity(intent);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
            builder.setMessage("Invalid Username or Password");

            builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

        }
            }
        });