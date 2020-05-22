public class EmargencyResponseActivity extends AppCompatActivity {

CountDownTimer timer;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //...

    }
    timer = new CountDownTimer(3000, 1000) {
        //Implementation
    }
}

@Override
protected void onPause(){
    if (timer != null) timer.cancel();
}

}