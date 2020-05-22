saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Custom", "Save buttn clicked");
                Intent intent = new Intent(EditMessageActivity.this, SendMessageActivity.class);
                intent.putExtra(MESSAGE, message);
                startActivity(intent);
                Log.i("Custom", "Custom Message created :" + message);
            }
        });