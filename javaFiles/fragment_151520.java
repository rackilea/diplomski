@Override
public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    switch (i) {
        case 0:
            description.setText(des[i]);
            preferences.edit().putInt(SELECTED_COLOR, Color.WHITE).apply();
            break;
        case 1:
            description.setText(des[i]);
            preferences.edit().putInt(SELECTED_COLOR, Color.BLUE).apply();
            break;
        case 2:
            description.setText(des[i]);
            preferences.edit().putInt(SELECTED_COLOR, Color.RED).apply();
            break;

    }
}