int[] a = new int[] {0,0};
ArrayList<int[]> b = new ArrayList<int[]>();

b.add(a.clone()); // add a distinct array
a[0] = 1;
a[1] = 1;
b.add(a);