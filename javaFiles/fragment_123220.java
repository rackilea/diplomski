public int age_minutes(Location last) {
    return age_ms(last) / (60*1000);
}

public long age_ms(Location last) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
        return age_ms_api_17(last);
    return age_ms_api_pre_17(last);
}

@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
private long age_ms_api_17(Location last) {
    return (SystemClock.elapsedRealtimeNanos() - last
            .getElapsedRealtimeNanos()) / 1000000;
}

private long age_ms_api_pre_17(Location last) {
    return System.currentTimeMillis() - last.getTime();
}