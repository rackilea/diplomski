public static void main(String[] args) throws IOException {

    // 1. create the pipes
    PipedInputStream inPipe = new PipedInputStream();
    PipedInputStream outPipe = new PipedInputStream();

    // 2. set the System.in and System.out streams
    System.setIn(inPipe);
    System.setOut(new PrintStream(new PipedOutputStream(outPipe), true));

    PrintWriter inWriter = new PrintWriter(new PipedOutputStream(inPipe), true);

    // 3. create the gui 
    JFrame frame = new JFrame("\"Console\"");
    frame.add(console(outPipe, inWriter));
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    // 4. write some output (to JTextArea)
    System.out.println("Hello World!");
    System.out.println("Test");
    System.out.println("Test");
    System.out.println("Test");

    // 5. get some input (from JTextArea)
    Scanner s = new Scanner(System.in);
    System.out.printf("got from input: \"%s\"%n", s.nextLine());
}