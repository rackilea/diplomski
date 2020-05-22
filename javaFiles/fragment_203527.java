Set<Integer> U = new TreeSet<Integer>();
U.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

StringBuilder sb = new StringBuilder(U.size());
for (int a : U)
    sb.append(a);

System.out.println(sb);