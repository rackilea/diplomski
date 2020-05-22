// This is the common class
class FuncPrinter {
  private Consumer<String> consumer;
  private Runnable runnable;

  public FuncPrinter(PrintWriter writer) {
    consumer = writer::println;
    runnable = writer::println;
  }

  public FuncPrinter(PrintStream stream) {
    consumer = stream::println;
    runnable = stream::println;
  }

  public void println(String line) {
    consumer.accept(line);
  }

  public void println() {
    runnable.run();
  }
}

class Talker {    
  void sayHello(FuncPrinter fp) {
    fp.println("Hello World");
    fp.println();
  }
}