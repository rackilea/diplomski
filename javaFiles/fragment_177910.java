if(!tempFile.exists())
   tempFile.createNewFile();

InputStream is = SplashActivity.this.getAssets().open(
                 DATABASE_NAME);
FileOutputStream os = new FileOutputStream(tempFile);