try {
        URL url = new URL("your url");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setDoOutput(true);

        OutputStreamWriter writer = new OutputStreamWriter(
                conn.getOutputStream(), "UTF-8");
        String request = "your json";
        writer.write(request);
        writer.flush();
        System.out.println("Code:" + conn.getResponseCode());
        System.out.println("mess:" + conn.getResponseMessage());

        String response = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            response += line;
        }

        System.out.println(new String(response.getBytes(), "UTF8"));
        writer.close();
        reader.close();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }