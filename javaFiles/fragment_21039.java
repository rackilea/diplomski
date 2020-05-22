package com.wolfdev.warriormail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends Activity implements OnClickListener{
    private Button loginButton;
    private EditText eText;
    private EditText pText;
    private CheckBox box;
    private String user; 
    private String pass;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

            //Initialize UI objects on main thread
        loginButton = (Button) findViewById(R.id.button1);
        loginButton.setOnClickListener(this);
        eText = (EditText) findViewById(R.id.editText1);
        pText = (EditText) findViewById(R.id.editText2);
        eText.clearFocus();
        pText.clearFocus();
        Animation fadeIn = AnimationUtils.loadAnimation(this,R.anim.fadeanimation);
        Animation slideIn = AnimationUtils.loadAnimation(this, R.anim.slideanimation);
        eText.startAnimation(slideIn);
        pText.startAnimation(slideIn);
        box = (CheckBox)findViewById(R.id.checkBox1);
        box.startAnimation(fadeIn);
        login.startAnimation(fadeIn);
    }

    @Override
    public void onClick(View v) {
        user = email.getText().toString();
        password = pass.getText().toString();

    }

    class LoginTask extends AsyncTask<Void,Void,Void>{
            @Override
            protected Void doInBackground(Void... args){
                    /* Here is where you would do a heavy operation
                    *  In this case, I want to validate a users
                    *  credentials.  If I would do this on the main
                    *  thread, it would freeze the UI.  Also since
                    *  this is networking, I am forced to do this on
                    *  a different thread.
                    */

                    return null;
            }

            @Override
            protected void onPostExecute(Void result){
                     /* This function actually runs on the main
                     * thread, so here I notify the user if the
                     * login was successful or if it failed.  If
                     * you want update the UI while in the background
                     * or from another thread completely, you need to
                     * use a handler.
                     */
            }
    }
}