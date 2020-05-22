private Printer print;

NewLineWriter(Printer print) {
    this.print = print;
}

public void run() {
    while (print.current <= print.MAX) {
        print.printNewLine();
    }
}