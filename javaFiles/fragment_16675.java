listView.setOnItemClickListener(new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
        long arg3) {
        try {
             if (player!=null && player.isPlaying())
              {                     
               player.stop();
               player.reset();
              }

            player.setDataSource(externalStoragePath +     "/Android/data/com.whizzappseasyvoicenotepad/" + recordedFilesArray.get(arg2) + ".mp3");
            player.prepare();
            player.start();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
});