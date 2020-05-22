if (requestCode == COLOR_PICKER_REQUEST && resultCode == RESULT_OK) {
   if (data != null && data.getExtras() != null) {
      Bundle bundle = data.getExtras();
      int colorBg = bundle.getInt(COLOR_CODE);
      findViewById(R.id.mainBg).setBackgroundColor(colorBg);
    }
 }