List<int[]> a = new ArrayList<int[]>();
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        a.add(new int[]{i, j});
    }
}
return (int[][])a.toArray(new int[0][0]);