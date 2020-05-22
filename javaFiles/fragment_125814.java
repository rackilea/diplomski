String[] a = new String[1];
if (a[0] == null) {
    a[0] = Integer.toString(1);
} else {
    a[0] += 1;
}
System.out.println(a[0]);