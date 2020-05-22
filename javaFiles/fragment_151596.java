public static void loadI() {
    i = new BigInteger(prefs.getString("I", "0"));
}

public static void saveI() {
    SharedPreferences.Editor editor = prefs.edit();
    editor.putString("I", i.toString());
    editor.apply();
}