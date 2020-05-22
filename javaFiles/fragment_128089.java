public static void main(String[] args) throws FileNotFoundException, IOException {
    Properties properties = new Properties();
    String str = "unicodedString=Hello \\u0022 World \\n \\u003C And so on.";
    StringReader stringReader = new StringReader(str);
    properties.load(stringReader);
    System.out.println(properties.getProperty("unicodedString"));
}