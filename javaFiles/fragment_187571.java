InputStream inputStream = new FileInputStream("config.properties");
 BufferedReader br = null;
 StringBuilder sb = new StringBuilder();
 String line;
 br = new BufferedReader(new InputStreamReader(inputStream));
 while ((line = br.readLine()) != null) {
     int length = line.length();
     for (int i = 0; i < length; i++) {
          if (line.charAt(i) != ' ') {
               sb.append(line.charAt(i));
           }
      }
      sb.append('\n');
 }
 InputStream inStream = new ByteArrayInputStream(sb.toString().getBytes());