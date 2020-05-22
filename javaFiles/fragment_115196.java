public static void main(String[] args) throws Exception {
    transform("<job>\n" +
              "    <id>7562882</id>\n" +
              "    <title>Techniker im Unterhalt (m/w) in Murten</title>\n" +
              "    <deleted>false</deleted>\n" +
              "</job>\n");
    System.out.println();   System.out.println();
    transform("<company>\n" +
              "        <id>40057210</id>\n" +
              "        <name>Roland Murten AG</name>\n" +
              "</company>\n");
}