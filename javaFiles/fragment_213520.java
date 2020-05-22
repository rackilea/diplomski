int height = 2, width = 3;  // of matrix B
int [][] a = {{0,1}, {2, 3}, {4, 5}};
int [][] b = {{0,1,2}, {3,4,5}};
Map<Integer, Integer> map = new HashMap<Integer, Integer>();
for (int i = 0; i < height; ++i) {
    for (int j = 0; j < width; ++j) {
        int b_val = b[i][j];
        int a_val = a[j][height - i - 1];
        map.put(a_val, b_val);
    }
}

Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
Iterator<Map.Entry<Integer, Integer>> it = entries.iterator();
while(it.hasNext()) {
    Map.Entry<Integer, Integer> e = it.next();
    System.out.println(e.getKey() + " -> " + e.getValue());
}