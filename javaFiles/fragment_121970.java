button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent replyIntent = new Intent();
            if(TextUtils.isEmpty(editText.getText())){
                setResult(RESULT_CANCELED, replyIntent);
            }else {
            String word = editText.getText().toString();
            replyIntent.putExtra(EXTRA_KEY,word);
            setResult(RESULT_OK, replyIntent); //missing
            }

            finish();
        }
    });