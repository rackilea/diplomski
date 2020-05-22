mSomeButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = getPackageManager()
                  .getLaunchIntentForPackage("com.abc.def"); //Teamviewer's app ID
            if(intent != null) {
                Bundle extras = new Bundle(); // if you need to pass some info
                extras.putString(key1, "SomeEmail@gmail.com");
                extras.putString(key2, "ldkjgkjgioerjijbmgjQ2349487598");
                intent.putExtras(extras);
                startActivity(intent);
            }
        }
    });