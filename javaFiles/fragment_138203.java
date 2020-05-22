if (android.os.Build.VERSION.SDK_INT >= 11) {
    Vibrator v = (Vibrator) RunnerJNILib.ms_context.getSystemService(Context.VIBRATOR_SERVICE);
    return ((v.hasVibrator()) ? 1 : 0);
} else {
    return 1;
}