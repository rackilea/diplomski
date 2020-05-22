if (storedPreference!=10) {
    ...stuff... (including storedPreference++)
}
if (storedPreference==10) {
    ...stuff...
} else {
    SharedPreferences.Editor editor = preferences.edit();
    editor.putInt("storedInt", 10);
    img.setImageResource(images[10]);
    img.invalidate();
}