public ArrayList<SongInfo> getAllSong(Context context) throws IOException {
        ArrayList<SongInfo> listSong = new ArrayList<SongInfo>();
        RingtonesSharedPreferences pref = new RingtonesSharedPreferences(context);
            String[] files = context.getAssets().list("Your songs path");
            for (int i = 0; i < files.length - 1; i++) {
                SongInfo info = new SongInfo();
                    String name = files[i];
                    if (!name.equals("ringtones")) {
                        info.setFileName(name + ".mp3");
                        info.setFavorite(pref.getString(info.getFileName()));
                    /*    int audioResource = R.raw.class.getField(name).getInt(name);
                        info.setAudioResource(audioResource);*/  //fileName is enough to you
                    }
                    // info.setName(name);
                listSong.add(info);
            }
            InputStream inputStream = context.getAssets().open("Your zeallist path");
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inputStream));
            try {
                String line;
                int i = 0;
                while ((line = reader.readLine()) != null) {
                    listSong.get(i).setName(line);
                    i++;
                }
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return listSong;
    }