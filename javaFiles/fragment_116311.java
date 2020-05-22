String result
String line;
      Process process = Runtime.getRuntime().exec(command);
      Reader r = new InputStreamReader(process.getInputStream());
      BufferedReader in = new BufferedReader(r);
      while ((line = in.readLine()) != null)
        result += line;
      in.close();