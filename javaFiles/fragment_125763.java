@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getParcelableExtra("path");
                try {
                    saveImageToSharedPreference(uri);
                    loadImageFromSharedPrefernce();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

private void saveImageToSharedPreference(Uri uri) {
        SharedPreferences.Editor editor = getSharedPreferences("PREF_NAME", MODE_PRIVATE).edit();
        editor.putString("imageUrl", String.valueOf(uri));
        editor.apply();
    }