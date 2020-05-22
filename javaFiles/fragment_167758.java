package com.example.com;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    // String for LogCat documentation
    private final static String TAG = "MainActivity";

    // These define the lengths for the dots, dashes, and times in between:
    private final static long TIME_UNIT = 250L;
    private final static long DOT_DELAY = TIME_UNIT * 2;
    private final static long DASH_DELAY = TIME_UNIT * 3;
    private final static long INTRA_LETTER_DELAY = TIME_UNIT;
    private final static long INTER_LETTER_DELAY = TIME_UNIT * 3;
    private final static long INTER_WORD_DELAY = TIME_UNIT * 7;

    private Button flasher = null;
    private EditText message = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flasher = (Button) findViewById(R.id.flasher);
        message = (EditText) findViewById(R.id.message);
    }

    public void doMorse(View vw) {
        String messageStr = message.getText().toString();
        if (messageStr.length() > 0) {

            // This creates and starts a background task to do the flashing:
            (new DoMorseFlashing()).execute(messageStr);

            // Set the button message to indicate that we're flashing a message:
            flasher.setText(R.string.flashing_message);
        }
    }

    private class DoMorseFlashing extends AsyncTask <String, Boolean, Void> {

        @Override
        protected Void doInBackground(String... message) {
            Log.v(TAG, "Starting Morse Code flasher...");

            for (char letter : message[0].toCharArray()) {
                if (letter == ' ')
                    doDelay(INTER_WORD_DELAY);
                else
                    showLetter(letter);
            }

            return null;
        }

        protected void onProgressUpdate(Boolean... flasherOn) {
            if (flasherOn[0])
                flasher.setBackgroundColor(Color.BLUE);
            else
                flasher.setBackgroundColor(Color.WHITE);
        }

        protected void onPostExecute(Void result) {
            // Set the button message back to "touch here" to indicate that we're done flashing:
            flasher.setText(R.string.touch_here);
        }

        void showLetter(char letter) {
            Log.v(TAG, "Flashing code for " + letter);

            switch (letter) {
                case 'A': showMorse(".-"); break;
                case 'B': showMorse("-..."); break;
                case 'C': showMorse("-.-."); break;

                // cases for the other letters...

                default: /* skip character */
            }

            doDelay(INTER_LETTER_DELAY);
        }

        void showMorse(String morse) {
            Log.v(TAG, "Flashing code " + morse);

            for (char dotDash: morse.toCharArray()) {
                Log.v(TAG, "Flashing " + dotDash);

                publishProgress(true);

                if (dotDash == '.')
                    doDelay(DOT_DELAY);
                else
                    doDelay(DASH_DELAY);

                doDelay(INTRA_LETTER_DELAY);
                publishProgress(false);
            }
        }

        void doDelay(Long delay) {
            try {
                Thread.sleep(delay);

            } catch (InterruptedException e) {
                // Ignore interruptions
            }
        }
    }
}