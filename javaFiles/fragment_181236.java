URL page = new URL(address);
    StringBuffer text = new StringBuffer();
    HttpURLConnection conn = (HttpURLConnection) page.openConnection();
    conn.connect();
    InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
    BufferedReader buff = new BufferedReader(in);
    box.setText("Getting data ...");
    String line;
    do {
      line = buff.readLine();
      text.append(line + "\n");
    } while (line != null);
    final String result = new String(text.toString());