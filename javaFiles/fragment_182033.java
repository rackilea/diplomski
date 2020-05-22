@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    updateMenu();
} 

@Override
public void onPrepareOptionsMenu(Menu menu) {
    // Do update staff with menu instance
}

private void updateMenu() {
    invalidateOptionsMenu();
}