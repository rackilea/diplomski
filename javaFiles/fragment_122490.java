URL url = new URL(urlString);
    URLConnection conn = url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestProperty ("Authorization", encodedCredentials);

    OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

    writer.write(data);
    writer.flush();
    String line;
    BufferedReader reader = new BufferedReader(new 
                                     InputStreamReader(conn.getInputStream()));
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
    writer.close();
    reader.close();