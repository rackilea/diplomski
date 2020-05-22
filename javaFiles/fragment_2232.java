int SDK_INT = android.os.Build.VERSION.SDK_INT;

if (SDK_INT > 8)
{
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
    StrictMode.setThreadPolicy(policy);

    // Where you get exception write that code inside this.
}