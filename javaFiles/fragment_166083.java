SharedPreferences getPreferences(Context context) {
    return PreferenceManager.getDefaultSharedPreferences(context);
}

void setEmail(Context context, String email) {
    SharedPreferences.Editor editor = getPreferences(context).edit();
    editor.putString("EMAIL", email);
    editor.apply();
}

String getEmail(Context context) {
    return getPreferences(context).getString("EMAIL", "");
}