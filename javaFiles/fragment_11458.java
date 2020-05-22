mChecker = new LicenseChecker(this, new StrictPolicy(), KEY);

mLicenseCheckerCallback = new MyLicenseCheckerCallback();

doCheck();

String KEY = "abcdefgijklmnopqrstuvqxyz"; //made up to post online

endis = (ToggleButton) findViewById(R.id.enableddis);

smessage = (Button) findViewById(R.id.savemess);

message = (EditText) findViewById(R.id.message);

getPrefs = PreferenceManager
        .getDefaultSharedPreferences(getBaseContext());

editor = getPrefs.edit();

final byte[] SALT = new byte[] { -46, 65, 30, -128, -103, -57, 74, -64,
        51, 88, -95, -45, 77, -117, -36, -113, -11, 32, -64, 89 };