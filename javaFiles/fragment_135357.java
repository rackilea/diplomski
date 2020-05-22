public void onCreate(Bundle savedInstanceState) {
    SharedPreferences prefs = getSharedPreferences("prefName", 0);
    int thicknessId = prefs.getInt("thicknessFieldName", 1); // Replace 1 with first-load state
    switchScribbleView(thicknessId);

    int colorId = prefs.getInt("colorFieldName", 4); // Replace 4 with first-load state
    switchScribbleView(colorId);

    //... rest of code
}

public boolean onOptionsItemSelected(MenuItem item) {
    int menuId = item.getItemId();

    //Get old values so they persist
    SharedPreferences prefs = getSharedPreferences("prefName", 0);
    int thicknessId = prefs.getInt("thicknessFieldName", 0);
    int colorId = prefs.getInt("colorFieldName", 0);

    if (menuId <= 2) // Control Thick and Thin
        thicknessId = menuId;
    else if (menuId >= 4) // Control Color
        colorId = menuId;

    Editor editor = getSharedPreferences("prefName", 0).edit();
    editor.putInt("thicknessFieldName", thicknessId);
    editor.putInt("colorFieldName", colorId);
    editor.commit();

    switchScribbleView(item.getItemId();
    return true;
}

private void switchScribbleView(int menuId) {
    switch (menuId) {
        //... switch block here
    }
}