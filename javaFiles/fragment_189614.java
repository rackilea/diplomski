private static final int REQUEST_CODE = 404;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    // Your code

    if (savedInstanceState == null) {
        tryToOpenHomeFragment();
    }
}

private void tryToOpenHomeFragment() {
    if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
        showHomeFragment();
    } else {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);
    }
}

@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == REQUEST_CODE) {
        if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            showHomeFragment();
        } else {
            // Permission was not granted
        }
    }
}

private void showHomeFragment() {
    HomeFragment fragment = new HomeFragment();
    getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.root_container, fragment)
            .commit();
}