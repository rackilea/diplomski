fun updateBackgroundColor() {
    val sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
    // Gets the text color from the shared preferences file
    val backgroundColor = sharedPref.getString("background_color_hex", "0x000000")
    val fullView = findViewById(R.id.fullscreen_content) as TextView?

    // Changes the text color based on the color the user has selected in Settings/Preferences
    int color = Color.parseColor(backgroundColor);
    fullView?.setBackgroundColor(color)
}