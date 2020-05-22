if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    askPermissions(true);
} else {
    startActivity(new Intent(PermissionsActivity.this, SplashActivity.class));
    finish();
}