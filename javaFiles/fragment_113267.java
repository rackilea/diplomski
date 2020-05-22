private boolean checkIfRebooted(Context context) {
    SharedPreferences prefs = context.getSharedPreferences("package.name.class", Context.MODE_PRIVATE);

    long savedUptime = prefs.getLong("timestamp", 0);
    long currentUptime = System.currentTimeMillis() - SystemClock.elapsedRealtime();

    // Giving it a threshold of 10ms since the calculation may be off by one sometimes.
    if (Math.abs(currentUptime - savedUptime) < 10)
        return false;

    prefs.edit().putLong("timestamp", currentUptime).apply();
    return true;
}