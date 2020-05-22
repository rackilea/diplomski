for (int i = 0 ; i < 5; i++) {
    do {
        try {
            ch1 = (char)System.in.read();
        } catch (Exception e) {}
    } while (ch1 == '\n' || ch1 == '\r');
    System.out.println(i);
}