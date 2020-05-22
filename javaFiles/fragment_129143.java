// This...
System.out.println(a[val = ((a = b)[3])]);
// Becomes...
int[] tmp = a; // So tmp is { 1, 2, 3, 4 }
a = b;
val = a[3]; // 0
System.out.println(tmp[val]); // 1