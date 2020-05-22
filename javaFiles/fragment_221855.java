public void sendRestRequest(String xmlFile) throws IOException {
        FileInputStream fis = new FileInputStream("configuration.properties");
        prop.load(fis);
        try {
            URL url = new URL(prop.getProperty("restURL"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/xml");
            conn.setRequestProperty("Authorization", prop.getProperty("basic"));

            String input = generateStringFromResource(xmlFile);

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder responseStrBuilder = new StringBuilder();

            String output;
            while ((output = br.readLine()) != null) {responseStrBuilder.append(output);}

            conn.disconnect();

            JSONObject result = new JSONObject(responseStrBuilder.toString());
            Assert.assertEquals(result.getString("status"), "UPLOADED");

        } catch (IOException e) {
            LOG.error(String.valueOf(e));
        }
    }