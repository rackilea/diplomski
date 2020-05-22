@Override
protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    ACRA.init(Application.this);
    ACRA.getErrorReporter().putCustomData("NAME_VALUE1", "VALUE1");
    ACRA.getErrorReporter().putCustomData("NAME_VALUE2", "VALUE2");
    ACRA.getErrorReporter().putCustomData("NAME_VALUE3", "VALUE3");
}