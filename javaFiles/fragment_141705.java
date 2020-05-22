public String doCompile(String compilationLang, String codeString,
                        String challengeName) throws InterruptedException, IOException {

  String output = null;
  String commandString = null;

  if (compilationLang == "java") {

    String path = "/home/john/IdeaProjects/Test1/src/";

    String commandStringCompile;
    String commandStringExcecute;
    commandStringCompile = "javac " + path + "Main.java";
    commandStringExcecute = "java -cp " + path +" Main";
    System.out.println("Command is " + commandStringCompile);
    System.out.println("Command is " + commandStringExcecute);
    final Process p = Runtime.getRuntime().exec(commandStringCompile);
    final Process   q = Runtime.getRuntime().exec(commandStringExcecute);
    Scanner err = new Scanner(p.getErrorStream());
    Scanner in = new Scanner(p.getInputStream());
    while (in.hasNext()) {
      System.out.println(in.next());
    }
    while (err.hasNext()) {
      System.out.println(err.next());
    }

    err = new Scanner(q.getErrorStream());
    in = new Scanner(q.getInputStream());
    while (in.hasNext()) {
      System.out.println(in.next());
    }
    while (err.hasNext()) {
      System.out.println(err.next());
    }
  }
  return output;
}