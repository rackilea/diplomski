public void delayedPrint(int delay, String s) {
    try {
        for (char c : s.toCharArray()) {
            System.out.print(c);  // print characters without newline
            Thread.sleep(delay);  // wait for some milli seconds
        }
    } catch (InterruptedException e) {
    }
    System.out.println(); // finally, add a line break
}