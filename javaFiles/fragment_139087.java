package com.example.user.store_session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.session.MediaSessionManager;
import android.os.UserManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,password;
    Button login;
       public static final String ARB="ARBAZ";
       public static final String NAME="USERNAME";
    public static final String PASSWORD="PASSWORD";
       SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.Edit_text_name);
        password=(EditText)findViewById(R.id.edit_text_password);
        login=(Button)findViewById(R.id.button_login);
        sharedPreferences=getSharedPreferences(ARB, Context
                .MODE_PRIVATE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_=name.getText().toString();
                String pass=password.getText().toString();

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(NAME,name_); //NAME IS THE KEY VALUE
                editor.putString(PASSWORD,pass);
                editor.commit();

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

           // check if NAME have a value. If have value, user has been logged, so go to the second activity.
          if ( !sharedPreferences.getString("NAME","").equals("") || !sharedPreferences.getString("PASSWORD","").equals("") ){
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
           }

    }
}