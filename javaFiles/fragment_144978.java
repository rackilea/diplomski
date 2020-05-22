public class Runner {

public static void main(String[] args) throws IOException {

    if(args.length != 2) {
        System.out.println("Usage : <xmlFile> <OutputFileName>");
        System.exit(-1);
    }

    Path path = Paths.get(args[0]);//Path to the xml

    new PrintWriter(args[1]).close();

    Charset charset = StandardCharsets.UTF_8;

    String content = new String(Files.readAllBytes(path), charset);
    content = content.replaceAll("theOutputFileNamePattern", args[1]);
    Files.write(path, content.getBytes(charset));

    //We create a testNG object to run the test specified in the xml file
    TestListenerAdapter tla = new TestListenerAdapter();
    TestNG testng = new TestNG();

    List<String> suites = Lists.newArrayList();
    suites.add(args[0]);

    testng.setTestSuites(suites);

    testng.run();

}

}