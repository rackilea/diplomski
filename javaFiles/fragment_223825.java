// Check for overlay permission. If not enabled, request for it. If enabled, show the overlay
        if(Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(context)){
            CharSequence text = "Please grant the access to the application.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.fromParts("package", getPackageName(), null)));
        } else {
            startPowerOverlay();
        }