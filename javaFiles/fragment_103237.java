int min = Integer.MAX_VALUE;
for (int i=0; i < n; i++) {
    t = in.nextInt();
    if (Math.abs(t) < Math.abs(min)) {
        min = t;
    }
}