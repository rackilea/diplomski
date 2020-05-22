InputStream instream = entity.getContent();
 BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
    StringBuilder sb = new StringBuilder();

    String line = null;
    try {
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
String contentString  = sb.toString(); //  you can pass sb.toString() directly to jsonobject as well