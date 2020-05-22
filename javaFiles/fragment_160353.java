FileInputStream fis = ...;

    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
    String line = null;
    while ((line = br.readLine()) != null) {
        // process the String line
    }