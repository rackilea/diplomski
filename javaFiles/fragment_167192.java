private synchronized static void println(ConsoleReader in, String text) throws IOException {
    in.printString("\r");

    in.printString(text + "\n");

    in.redrawLine();
    in.flushConsole();
}