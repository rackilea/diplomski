public String printPath(Graph graph, String end) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(bos);
    //set output stream to bos to capture output
    System.setOut(printStream);

    graph.get(end).printPath(); //your output
    System.out.println();

    //reset output stream to file descriptor
    System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    return bos.toString();
}