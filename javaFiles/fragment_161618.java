public class CustomProgressBar extends Dialog {
Context context;
String message;
TextView textViewMessage;
ProgressWheel wheel;

public CustomProgressBar(Context context, String message) {
    super(context);
    // TODO Auto-generated constructor stub
    this.context = context;
    this.message = message;
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
    getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    setContentView(R.layout.dialog_progress);
    textViewMessage = (TextView) findViewById(R.id.textViewMessage);
    wheel = (ProgressWheel) findViewById(R.id.progressWheel);

}

@Override
protected void onStart() {
    // TODO Auto-generated method stub
    super.onStart();
    wheel.spin();
    textViewMessage.setText(message);
}

}