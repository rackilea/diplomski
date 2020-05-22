URL obj = new URL(String url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(conn.getInputStream());