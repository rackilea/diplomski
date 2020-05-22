List C = new ArrayList(Arrays.asList(4, 5, 6));
List B = new ArrayList(Arrays.asList(2, 3, C, 7));
List A = new ArrayList(Arrays.asList(1, B, 8, 9, C));
C.add(C);
B.add(B);
A.add(A);

System.out.println(A);
System.out.println(flatten(A, new HashSet<>()));