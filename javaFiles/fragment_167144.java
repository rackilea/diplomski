upload.setOnClickListener(new View.OnClickListener() {
    public void onClick(View arg0) {
        String ID = "", Image;
        int Nummer = 0;
        [...]

        for (int i = 0; i < files.length; ++i) {
            if (files[i].getName().endsWith(".jpg")) {
                [...]

                try {
                    new HttpAsyncTask(ID,Image,Integer.toString(Nummer++)).execute("https://....");
                } catch (Exception e) {
                    Log.e("InputStream", e.getMessage());
                }

                Log.e("PICS", id);
            }
        }
    }
});