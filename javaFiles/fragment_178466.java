private void addShortcut() {
    //Adding shortcut for MainActivity 
    //on Home screen
    Intent shortcutIntent = new Intent(getApplicationContext(),
            MainActivity.class);

    shortcutIntent.setAction(Intent.ACTION_MAIN);

    Intent addIntent = new Intent();
    addIntent
            .putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
    addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "HelloWorldShortcut");
    addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
            Intent.ShortcutIconResource.fromContext(getApplicationContext(),
                    R.drawable.ic_launcher));

    addIntent
            .setAction("com.android.launcher.action.INSTALL_SHORTCUT");
    addIntent.putExtra("duplicate", false);  //may it's already there so don't duplicate
    getApplicationContext().sendBroadcast(addIntent);
}