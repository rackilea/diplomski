label:
while (true) {
    for (int i = 0; i < 100; i++) {
        System.out.println("i = " + i);
        if (i == 99) {
            continue label;
        }
    }
}