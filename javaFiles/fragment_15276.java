final File file = new File(Environment.getExternalStorageDirectory() + "/download/app-debug.apk");
  bt_install.setEnabled(!file.exists());
  btinstall.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Download file and do the rest