private SharedPreferences sharedPreferences;
private Button btn_download_one, btn_download_two, btn_download_three, btn_download_four;
private final String DOWNLOAD_BUTTON_STATUS_KEY_ONE = "DOWNLOAD_BUTTON_STATUS_ONE";
private final String DOWNLOAD_BUTTON_STATUS_KEY_TWO = "DOWNLOAD_BUTTON_STATUS_TWO";
private final String DOWNLOAD_BUTTON_STATUS_KEY_THREE = "DOWNLOAD_BUTTON_STATUS_THREE";
private final String DOWNLOAD_BUTTON_STATUS_KEY_FOUR = "DOWNLOAD_BUTTON_STATUS_FOUR";
private int clickCountOne = 0, clickCountTwo = 0, clickCountThree = 0, clickCountFour = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn_download_one = findViewById(R.id.button1);
    btn_download_two = findViewById(R.id.button2);
    btn_download_three = findViewById(R.id.button3);
    btn_download_four = findViewById(R.id.button4);
    sharedPreferences = getSharedPreferences("MY_PREF", 0);
    btn_download_one.setEnabled(getDownloadButtonStatusPref(DOWNLOAD_BUTTON_STATUS_KEY_ONE));
    btn_download_two.setEnabled(getDownloadButtonStatusPref(DOWNLOAD_BUTTON_STATUS_KEY_TWO));
    btn_download_three.setEnabled(getDownloadButtonStatusPref(DOWNLOAD_BUTTON_STATUS_KEY_THREE));
    btn_download_four.setEnabled(getDownloadButtonStatusPref(DOWNLOAD_BUTTON_STATUS_KEY_FOUR));


    btn_download_one.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //... some code
            clickCountOne++;
            if (clickCountOne == 2)
                changeDownloadButtonStatusPref(DOWNLOAD_BUTTON_STATUS_KEY_ONE, false);

        }
    });
    btn_download_two.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //... some code
            clickCountTwo++;
            if (clickCountTwo == 2)
                changeDownloadButtonStatusPref(DOWNLOAD_BUTTON_STATUS_KEY_TWO, false);

        }
    });
    btn_download_three.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //... some code
            clickCountThree++;
            if (clickCountThree == 2)
                changeDownloadButtonStatusPref(DOWNLOAD_BUTTON_STATUS_KEY_THREE, false);

        }
    });
    btn_download_four.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //... some code
            clickCountFour++;
            if (clickCountFour == 2)
                changeDownloadButtonStatusPref(DOWNLOAD_BUTTON_STATUS_KEY_FOUR, false);

        }
    });

}

private void changeDownloadButtonStatusPref(String key, boolean status) {
    sharedPreferences.edit().putBoolean(key, status).apply();
    switch (key) {
        case DOWNLOAD_BUTTON_STATUS_KEY_ONE:
            btn_download_one.setEnabled(status);
            clickCountOne = 0;
            break;
        case DOWNLOAD_BUTTON_STATUS_KEY_TWO:
            btn_download_two.setEnabled(status);
            clickCountTwo = 0;
            break;
        case DOWNLOAD_BUTTON_STATUS_KEY_THREE:
            btn_download_three.setEnabled(status);
            clickCountThree = 0;
            break;
        case DOWNLOAD_BUTTON_STATUS_KEY_FOUR:
            btn_download_four.setEnabled(status);
            clickCountFour = 0;
            break;
    }
}

private boolean getDownloadButtonStatusPref(String key) {
    return sharedPreferences.getBoolean(key, true);
}