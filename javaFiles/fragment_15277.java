@Override
public void onResume() {
      super.onResume();
      final File file = new File(Environment.getExternalStorageDirectory() + "/download/app-debug.apk");
      bt_install.setEnabled(!file.exists());
}