package com.example.androidlistview;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends Activity {


    //Variables for Bundle
    int image;
    String name;
    String address;
    String phone;
    String email;
    String note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Button SMS = (Button) findViewById(R.id.button1);
        SMS.setOnClickListener(new OnClickListener() {
            //when button1 is clicked open messenger
            @Override
            public void  onClick(View v) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", phone, null)));
            }

        });

        Button Email = (Button) findViewById(R.id.button2);
        Email.setOnClickListener(new OnClickListener() {
            //when button2 is clicked open email
            @Override
            public void  onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { email });
                startActivity(Intent.createChooser(emailIntent, "Choose Email Client"));

            }

        });

        Button Phone = (Button) findViewById(R.id.button3);
        Phone.setOnClickListener(new OnClickListener() {
            //when button3 is clicked start call
            @Override
            public void  onClick(View v) {

                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null)));
            }

        });


        // get details passed from MainActivity
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            image= bundle.getInt("image");
            ImageView imageView = (ImageView) findViewById(R.id.imageView1);    
            imageView.setImageResource(image);

            name = bundle.getString("name");
            TextView nameView = (TextView) findViewById(R.id.name1);    
            nameView.setText(name);

            address = bundle.getString("address");
            TextView addressView = (TextView) findViewById(R.id.address1);    
            addressView.setText(address);

            phone = bundle.getString("phone");
            TextView phoneView = (TextView) findViewById(R.id.phone1);    
            phoneView.setText(phone);

            email = bundle.getString("email");
            TextView emailView = (TextView) findViewById(R.id.email1);    
            emailView.setText(email);

            note = bundle.getString("note");
            TextView noteView = (TextView) findViewById(R.id.note1);    
            noteView.setText(note);

        }

    }
}