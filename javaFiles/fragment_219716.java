public ArrayList<Canciones> getJsonResults(){
        ArrayList<Canciones> cancioesList = new ArrayList();

        InputStream is = getResources().openRawResource(R.raw.song_data);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        finally {

            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String jsonString = writer.toString();
        try {

            JSONArray objects = new JSONArray(jsonString);
            for (int i = 0; i < objects.length(); i++) {
                Canciones canciones = new Canciones();
                JSONObject cancionesObj = objects.getJSONObject(i);
                int id = cancionesObj.getInt("id");
                String song_title = cancionesObj.getString("song_title");
                String album = cancionesObj.getString("album");
                String cover =  cancionesObj.getString("cover");
                String song_id =  cancionesObj.getString("song_id");
                String artist =  cancionesObj.getString("artist");
                canciones.setId(id);
                canciones.setSongTitle(song_title);
                canciones.setAlbum(album);
                canciones.setCover(cover);
                canciones.setSongId(song_id);
                canciones.setArtist(artist);
                cancioesList.add(canciones);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return cancioesList;
    }