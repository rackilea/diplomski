final Scanner scan = new Scanner(string);

scan.useDelimiter("\t");

while (scan.hasNext()) {
    final String url = scan.next();
    if (url.contains(".com.jp")) {
        bufferedWriter.write(url);
        bufferedWriter.write("\t");
        System.out.println(url);
    }
}