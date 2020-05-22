StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 500000; i++) {
        sb.append(i).append("\n");
    }
    String str = sb.toString();
    long nt = System.nanoTime();
    System.out.print(str);
    nt = System.nanoTime() - nt;
    System.out.print("\nTime(ms): " + (double)nt / 1000000);