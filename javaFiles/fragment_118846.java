@Override
public void onCreate(Bundle savedInstanceState) {
    Intent intent = getIntent();
    if(intent.hasExtras) {
        Bundle data = intent.getExtras();
        // Your data
    }
}