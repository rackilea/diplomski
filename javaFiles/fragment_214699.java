protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ...

    if (!((MyAppCtx)getApplicationContext()).toasted) {
        Toast.makeText(getApplicationContext(), "WELCOME!!!" , Toast.LENGTH_LONG).show();
        ((MyAppCtx)getApplicationContext()).toasted = true;
    }

    ...
}