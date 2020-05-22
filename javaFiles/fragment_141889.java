@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE) {
            if (resultCode == RESULT_OK) {
                // User pick the file
                Uri uri = data.getData();
                String fileContent = readTextFile(uri);
                Toast.makeText(this, fileContent, Toast.LENGTH_LONG).show();
            } else {
                Log.i(TAG, data.toString());
            }
        }
    }