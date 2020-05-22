CheckBox checkBox = (CheckBox) findViewById(R.id.cb_remember_me);
checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences sharedPreferences = getSharedPreferences("MY_PREFERENCES", MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("remember_me", isChecked).commit();
        }
    });