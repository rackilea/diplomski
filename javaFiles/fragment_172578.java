private Printer print;

ItemWriter(Printer print) {
    this.print = print;
}

public void run() {
    while (print.current <= print.MAX) {
        print.printNumber();
    }
}