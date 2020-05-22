final StringBuilder sb = new StringBuilder();
for (int i = 0; i < n; i++) {
    if (sb.length() > 100000) {
        System.out.print(sb);
        sb.delete(0, sb.length());
    }

    final int x = Integer.parseInt(br.readLine());
    final int y = Integer.highestOneBit(x);
    sb.append(y).append("\n");
}
System.out.print(sb);