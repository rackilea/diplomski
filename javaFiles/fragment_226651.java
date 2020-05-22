package com.scompt.so16209790;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class MainActivity extends Activity {
    private static final Random RANDOM = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Handler handler = new RandomMoveHandler((TextView) findViewById(R.id.text_view));
        handler.sendEmptyMessage(0);
    }

    // Make the handler subclass static because of this: http://stackoverflow.com/a/11408340/111777
    private static class RandomMoveHandler extends Handler {
        private final WeakReference<TextView> textViewWeakReference;

        private RandomMoveHandler(TextView textView) {
            this.textViewWeakReference = new WeakReference<TextView>(textView);
        }

        @Override
        public void handleMessage(Message msg) {
            TextView textView = textViewWeakReference.get();
            if (textView == null) {
                Log.i(TAG, "WeakReference is gone so giving up.");
                return;
            }

            int x = RANDOM.nextInt(350 - 100);
            int y = RANDOM.nextInt(800 - 100);

            Log.i(TAG, String.format("Moving text view to (%d, %d)", x, y));
            textView.setX(x);
            textView.setY(y);

            //change the text position here
            this.sendEmptyMessageDelayed(0, 3000);
        }
    }

    private static final String TAG = MainActivity.class.getSimpleName();
}