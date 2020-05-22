EditTextGraphee.OnKeyPreImeListener onKeyPreImeListener = 
        new EditTextGraphee.OnKeyPreImeListener() {
        @Override
        public void onBackPressed() {
            Log.d(TAG, "CALL BACK RECEIVED");
            MyActivity.this.onBackPressed();
        }
    };
editText.setOnKeyPreImeListener(onKeyPreImeListener);