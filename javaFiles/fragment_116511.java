AssetManager am = this.getAssets(); // or YourActivity.this.getAssets()
   try { // generally Context
      InputStream is = am.open("yourFile.suffix");
   }
   catch (IOException e) {
      Log.w("IOException", e.getMessage());
   }