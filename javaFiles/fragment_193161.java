BufferedReader br = null;
StringBuilder sb = new StringBuilder();
String line;
try {
    br = new BufferedReader(new InputStreamReader(stream));
    while ((line = br.readLine()) != null) {
        sb.append(line);
    }
    String result = sb.toString();
    //comma is the charater which seperates the prefix and the Base64 String
    int i = result.indexOf(",");
    result = result.substring(i + 1);
    //Now, that we have just the Base64 encoded String, we can decode it
    Base64.Decoder decoder = Base64.getDecoder();
    byte[] decoded = decoder.decode(result);
    //Now, just write each byte from the byte array to the output stream
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (br != null) {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}