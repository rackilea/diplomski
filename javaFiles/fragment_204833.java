private int setMockLocationSettings() {
    int value = 1;
    try {
        value = Settings.Secure.getInt(getContentResolver(),
                Settings.Secure.ALLOW_MOCK_LOCATION);
        Settings.Secure.putInt(getContentResolver(),
                Settings.Secure.ALLOW_MOCK_LOCATION, 1);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return value;
}

private void restoreMockLocationSettings(int restore_value) {
    try {
        Settings.Secure.putInt(getContentResolver(),
                Settings.Secure.ALLOW_MOCK_LOCATION, restore_value);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

/* every time you mock location, you should use these code */
int value = setMockLocationSettings();//toggle ALLOW_MOCK_LOCATION on
try {
    mLocationManager.setTestProviderLocation(LocationManager.GPS_PROVIDER, fake_location);
} catch (SecurityException e) {
    e.printStackTrace();
} finally {
    restoreMockLocationSettings(value);//toggle ALLOW_MOCK_LOCATION off
}