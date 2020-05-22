public void printStreamName(OutputStream stream) {
    String streamName = "Other";

    if(stream instanceof PrintStream) {
        streamName = stream == System.err ? "System.err" : (stream == System.out ? "System.out" : "Other");
    }

    System.out.println("This is stream: " + streamName);
}