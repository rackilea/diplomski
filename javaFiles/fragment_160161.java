public void gameover() { 
    // Get the saved value
    SharedPreferences prefsplay = this
        .getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
    playcount = prefsplay.getInt("play_number", 0);

    if (playcount >= 10) {
        playcount = 0;
        showInterstitial();

        SharedPreferences prefsplay = getApplicationContext()
            .getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        prefsplay.edit().putInt("play_number", playcount).apply();

        // Start loading the new ad
        loadNewAd();
    }
}