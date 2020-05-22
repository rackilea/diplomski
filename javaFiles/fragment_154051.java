public class MainActivity extends Activity {

    // all your code

    public void onResult(Integer result) {
        tv.setText("my result is: " + result);
    }
}