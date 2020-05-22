StringBuilder buf = new StringBuilder();

for (int i = 1; i <= 5; i++) {
    buf.append(i);

    for (int j = 1; j <= i; j++) {
        System.out.println(buf);
    }
}