package com.example.teststack;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainRequest extends Activity {

    EditText textPersonName = null;
    EditText textPostalAddress = null;
    EditText phone = null;
    EditText textMultiLine = null;
    Button submit = null;
    String action = "http://www.omokoroacomputerhelp.com/";
    HttpPost httpRequest = null;
    List<NameValuePair> params = null;
    HttpResponse httpResponse = null;
    WebView webView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_request);
        textPersonName = (EditText) findViewById(R.id.personName);
        textPostalAddress = (EditText) findViewById(R.id.postalAddress);
        phone = (EditText) findViewById(R.id.phone);
        textMultiLine = (EditText) findViewById(R.id.multiLine);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                httpRequest = new HttpPost(action);
                params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("name", textPersonName
                        .getText().toString()));
                params.add(new BasicNameValuePair("phone", phone.getText()
                        .toString()));
                params.add(new BasicNameValuePair("addr", textPostalAddress
                        .getText().toString()));
                params.add(new BasicNameValuePair("comment", textMultiLine
                        .getText().toString()));
                try {
                    // send http request
                    httpRequest.setEntity(new UrlEncodedFormEntity(params,
                            HTTP.UTF_8));
                    // get http response
                    httpResponse = new DefaultHttpClient().execute(httpRequest);
                    //
                    Intent gotoIntent = new Intent(MainRequest.this,
                            Webpage.class);
                    gotoIntent.putExtra("source",
                            EntityUtils.toString(httpResponse.getEntity()));
                    startActivity(gotoIntent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_request, menu);
        return true;
    }

}