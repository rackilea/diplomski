final boolean overlayEnabled = Settings.canDrawOverlays(MainActivity.this);

 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !overlayEnabled) {
   openOverlaySettings();
 }



 @TargetApi(Build.VERSION_CODES.M)
    private void openOverlaySettings() {
        final Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:" + getPackageName()));
        try {
            startActivityForResult(intent, RC_OVERLAY);
        } catch (ActivityNotFoundException e) {
            Log.e("MainActivity", e.getMessage());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RC_OVERLAY:
                final boolean overlayEnabled = Settings.canDrawOverlays(this);
                if (overlayEnabled) {
                    preferenceManager.setBooleanPref(IS_CYBER_BULLING_ON, true);
                    Intent intent = new Intent(MainActivity.this, ImePreferences.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else {
//                    switchCyberBulling.setChecked(false);
                }
                // Do something...
                break;
        }
    }