class ABC extends Activity {
    AppData appData;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xyz);

        appData = AppData.getAppData();
        ...........
        ...........

        appData.VARIABLE_NAME...
    }
}