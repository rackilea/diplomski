public void run() {
    try {
        for (int i = 1; i <= 100; i++) {
            synchronized(printer) {
                System.out.println(printer.isOdd);
                if (i % 2 == 1) {
                    while (printer.isOdd == false) {
                        printer.wait();
                    }
                    System.out.println(getName() + ": " + i);
                    printer.isOdd = false;
                    printer.notifyAll();
                }
            }
        }
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}