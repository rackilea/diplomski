int[] col = new int[pSize];
for (int i = 0; i < p.length; i++) {
    col[i] = (int)p[i].getX();
}
Arrays.sort(col);
System.out.println(Arrays.toString(col));