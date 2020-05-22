BufferedReader br = null;
StringBuilder sb = new StringBuilder();
String line;
try {
    br = new BufferedReader(new InputStreamReader(stream));
    while ((line = br.readLine()) != null) {
        sb.append(line);
    }
    return sb.toString();
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