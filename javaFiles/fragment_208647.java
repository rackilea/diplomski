import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Vibrator;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    Vibrator vibrator;
    VibratePattern task;
    Button stop_button;
    Button start_button;
    MyTaskParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        stop_button = (Button) findViewById(R.id.button_stop);
        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.cancel(true);
                task = null;
            }
        });
        start_button = (Button) findViewById(R.id.button_start);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (task == null) {
                    startTask();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private static class MyTaskParams {
        int dot, dash, gap;

        MyTaskParams (int dot, int dash, int gap) {
            this.dot = dot;
            this.dash = dash;
            this.gap = gap;
        }
    }

    private void startTask() {
        params = new MyTaskParams(200,500,200);
        task = new VibratePattern();
        task.execute(params);
    }

    public Integer onVibrate (Integer dot, Integer dash, Integer gap) {
        long[] pattern = {
                0,
                dot, gap, dash, gap, dot, gap, dot
        };

        vibrator.vibrate(pattern, -1);
        int span = dot + gap + dash + gap + dot + gap + dot + gap;
        return span;
    }

    private class VibratePattern extends AsyncTask<MyTaskParams, Void, Integer> {

        @Override
        protected Integer doInBackground(MyTaskParams... params) {
            int span;
            span = onVibrate(params[0].dot,params[0].dash,params[0].gap);
            return span;
        }

        @Override
        protected void onPostExecute(Integer span) {
            final android.os.Handler handler = new android.os.Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!isCancelled()) {
                        startTask();
                    }
                }
            }, span);
        }
    }
}