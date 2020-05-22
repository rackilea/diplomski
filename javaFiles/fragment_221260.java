public static void main(String args[]) {
    String encoding = "UTF-8"; // try "UTF-8" first and also change to other encodings to see the results

    StringBuilder sb = new StringBuilder();
    try(Reader reader = new InputStreamReader(new FileInputStream("node.txt"), encoding)) {
        int c = -1;
        while ((c = reader.read()) != -1) {
            if (eligible(c)) {
                sb.append((char)c);
            }
        }
    } catch (Exception e){
        e.printStackTrace();
    }

    int index = sb.indexOf("settings.bluetooth");
    if (index >= 0) {
        System.out.println(sb.substring(index));
    }
}

public static boolean eligible(int c) {
    return (c >= 'a' && c <= 'z' || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '.');
}