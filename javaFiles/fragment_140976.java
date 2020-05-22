package com.example.speech_to_text_experiments;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public  class MainActivity extends Activity  implements RecognitionListener
{

 private ListView wordsList;
 Button btn;
 TextView tv;
private SpeechRecognizer mSpeechRecognizer;
private Intent mSpeechRecognizerIntent; 


protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
    mSpeechRecognizer.setRecognitionListener(this);
    mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                                     RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
    mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                                     this.getPackageName());
    btn=(Button)findViewById(R.id.button1);

    wordsList = (ListView) findViewById(R.id.listView1); 

   mSpeechRecognizer.setRecognitionListener(new RecognitionListener() {

    @Override
    public void onRmsChanged(float rmsdB) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onResults(Bundle results) {
        // TODO Auto-generated method stub
        ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);


        wordsList.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,  matches));

            Toast.makeText(MainActivity.this, "Recognision OK!!!", Toast.LENGTH_SHORT).show(); 

    }

    @Override
    public void onReadyForSpeech(Bundle params) {
        // TODO Auto-generated method stub
        Toast.makeText(MainActivity.this, "Voice recording starts", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPartialResults(Bundle partialResults) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onEvent(int eventType, Bundle params) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onError(int error) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onEndOfSpeech() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onBufferReceived(byte[] buffer) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onBeginningOfSpeech() {
        // TODO Auto-generated method stub

    }
});



    btn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

             mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
        }
    });



}


    public void onBeginningOfSpeech(){ }

        public void onBufferReceived(byte[] buffer){ }

        public void onEndOfSpeech(){ }

        public void onError(int error){

           //mSpeechRecognizer.startListening(mSpeechRecognizerIntent);

    }

    public void onEvent(int eventType, Bundle params){ }


    public void onPartialResults(Bundle partialResults){ }


    public void onReadyForSpeech(Bundle params){




    }

    public void onResults(Bundle results)
    {

        ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);


        wordsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  matches));

            Toast.makeText(MainActivity.this, "Recognision OK!!!", Toast.LENGTH_SHORT).show(); 

    }

    public void onRmsChanged(float rmsdB) { }

  }