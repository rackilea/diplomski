public static void main(String agr[]) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(
            "yourfilelocation"));
    String line = null;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
}