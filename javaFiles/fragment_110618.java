public static void main(String[] args) throws Exception {
    Pattern pattern = Pattern.compile("^(\\\\n[+|-])(.*?)(\\\\n.*)?$"); 
    Matcher matcher = null;

    BufferedReader br = new BufferedReader(new FileReader(
            "filePath"));
    String line = null;
    while ((line = br.readLine()) != null) {
        matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.println(matcher.group(2));
        }
    }
}