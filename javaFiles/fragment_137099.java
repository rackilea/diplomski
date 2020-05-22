AsyncTask.execute(new Runnable() {
   @Override
   public void run() {
    AssetManager assetManager = this.getAssets();
    try {
        InputStream inputStream = assetManager.open("3333.ecg");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            stringBuilder.append(str);
    }
    } catch (IOException e) {
        e.printStackTrace();
    }
   }
});