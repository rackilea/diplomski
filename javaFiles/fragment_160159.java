private final int ACTION_GAME = 100; 

public void restart(View view) {
    Intent intent = new Intent(this, GameScreen.class);
    startActivityForResult(intent, ACTION_GAME);
    playcount++;

    SharedPreferences prefsplay = this
        .getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
    prefsplay.edit().putInt("play_number", playcount).apply();
}