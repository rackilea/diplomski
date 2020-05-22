public static void main(String [] args) {
    Pattern p = Pattern.compile("<option value=\"(.*?)\">(.*?)</option>");
    String line = "<option value=\"{1}\">hello0</option>";
    Matcher m = p.matcher(line);
    while (m.find()) {
        String value = m.group(1);
        String name = m.group(2);
        System.out.println(value);
        System.out.println(name);
        // Now add to your arrays
    }
}