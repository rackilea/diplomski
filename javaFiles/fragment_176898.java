//Actions à réaliser en fond
        protected String doInBackground(String... params) {

            //Création d'une requête HTTP
            HttpClient httpClient = new DefaultHttpClient();  

            //On construit notre adresse Post grâce à ce que l'on vient de récupérer
            HttpPost httppost = new HttpPost("http://your_id.appspot.com/upload");

            //On créé un fichier File qui contient la photo que l'on vient de prendre (Accessible via son Path) 
            File f = new File(AccueilActivity.fileUri.getPath());

            //Et là on essaie !
            try {               

                 MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
                 entityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE); 
                 entityBuilder.addBinaryBody("Photo_a_uploader", f);             
                 entityBuilder.addTextBody("Type", "Type que l'utilisateur a choisi");

                 httppost.setEntity(entityBuilder.build());
                 HttpResponse response = httpClient.execute(httppost);              


        } catch (ClientProtocolException e) {
            // Si on tombe dans le catch, on set notre variable à 2.        
            e.printStackTrace();

        } catch (IOException e) {
            // Si on tombe dans le catch, on set notre variable à 2.            
            e.printStackTrace();
        }