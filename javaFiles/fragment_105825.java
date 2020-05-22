int pSize = 5;
Point[] p = new Point[pSize];

Random z = new Random();
for (int i = 0; i < p.length; i++) {
    p[i] = new Point(i+z.nextInt(5), i);
}

System.out.println(Arrays.toString(p));

int[] col = new int[pSize];
for (int i = 0; i < p.length; i++) {
    col[i] = (int)p[i].getX();
}
Arrays.sort(col);
System.out.println(Arrays.toString(col));