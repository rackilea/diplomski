final Intent intent = new Intent();
intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, selectedApp.label);

// this line in your code changed
intent.putExtra(Intent.EXTRA_SHORTCUT_ICON, icon.getBitmap());

intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
sendBroadcast(intent);