String deviceId = Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);

mLicenseCheckerCallback = new MyLicenseCheckerCallback();
mChecker = new LicenseChecker(
        getApplicationContext(), new ServerManagedPolicy(this,
                new AESObfuscator(SALT, getPackageName(), deviceId)),
        BASE64_PUBLIC_KEY);

mChecker.checkAccess(mLicenseCheckerCallback);