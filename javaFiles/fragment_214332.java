HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://www.liliandgizmo.legtux.org/lilyCreation/getCategorie.php");
        // post.setEntity(new UrlEncodedFormEntity(validateMessage(m)));

        HttpResponse response = client.execute(post);
        StatusLine status = response.getStatusLine();

        if (status.getStatusCode() == 200) {
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();

            final Gson gson = new GsonBuilder().create();
            try {
                Reader read = new InputStreamReader(is);

                BufferedReader in = new BufferedReader(read); //added
                String inputLine; //added
                while ((inputLine = in.readLine()) != null) //added
                    System.out.println(inputLine); //added
                in.close(); //added

                //List<Categorie> mList = gson.fromJson(read, new TypeToken<List<Categorie>>() {
                }.getType());
                is.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }