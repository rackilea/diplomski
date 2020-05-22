public class MyClass extends Activity {

    private TextView tvc;
    private TextView tvd;
    private TextView tvp;

    ... // somewhere here you need to get the TextViews from the Layout
    ... // missing out lots of code here and skipping straight to onProgressChanged for first seekBar

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
            boolean fromUser) {
        String progress1 = String.valueOf(progress-100)
        tvc.setText(progress1);
        String progress2 = tvd.getText().toString;
        String result = resultOfSomeCalculationUsingTheInputs();
        tvp.setText(result);
    }
}