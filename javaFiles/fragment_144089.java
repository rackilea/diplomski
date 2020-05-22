saveButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i("Custom", "Save buttn clicked");
            Intent intent = new Intent();
            intent.putExtra(MESSAGE, message);
            setResult(RESULT_OK, intent);
            finish();
            Log.i("Custom", "Custom Message created :" + message);
        }
    });