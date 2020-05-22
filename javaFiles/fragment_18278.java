public static void main(String[] args) throws IOException {

    InputStream in = new FileInputStream(new File("abc.properties"));

    new Properties().load(in);

    System.out.println(in.read());
}