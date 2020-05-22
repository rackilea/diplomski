package com.arrdude.forumanswer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends Activity implements OnClickListener {
    EditText headeredittext = null;
    EditText subheadedittext = null;
    Button donebutton = null;
    Button cancelbutton = null;

    public EditText getHeaderedittext() {
        if(headeredittext==null){
            headeredittext = (EditText) findViewById(R.id.headedittext);
        }
        return headeredittext;
    }

    public EditText getSubheadedittext() {
        if(subheadedittext==null){
            subheadedittext = (EditText) findViewById(R.id.subedittext);
        }
        return subheadedittext;
    }

    public Button getDonebutton() {
        if(donebutton==null){
            donebutton = (Button) findViewById(R.id.adddonebutton);
            donebutton.setClickable(true);
            donebutton.setOnClickListener(this);
        }
        return donebutton;
    }

    public Button getCancelbutton() {
        if(cancelbutton==null){
            cancelbutton = (Button) findViewById(R.id.addcancelbutton);
            cancelbutton.setOnClickListener(this);
        }
        return cancelbutton;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additem);
        //lazy init objects not the most efficient in Android but easier reading
        getHeaderedittext();
        getSubheadedittext();
        getDonebutton();
        getCancelbutton();
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
        case R.id.addcancelbutton:
            finish();
            break;

        case R.id.adddonebutton:
            sendResult();
            break;

        default:
            break;
        }
    }

    private void sendResult() {
        Intent resultI = new Intent();
        resultI.putExtra(TestResultActivity.ADAPTER_VALUE_1, getHeaderedittext().getText().toString());
        resultI.putExtra(TestResultActivity.ADAPTER_VALUE_2, getSubheadedittext().getText().toString());
        setResult(RESULT_OK, resultI);
        finish();
    }
}