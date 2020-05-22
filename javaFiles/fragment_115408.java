InputStream stream = getResources().openRawResource(R.raw.textfile);
BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String readLine = null;

        try {
            while ((readLine = br.readLine()) != null) {


            }
        } catch (IOException e) {
            e.printStackTrace();
        }