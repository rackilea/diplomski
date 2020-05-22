public static void printMapAsMatrix(Map<Integer, Integer> map, int size) {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            Integer v = map.get(size * i + j);
            if (v == null)
                v = 0;
            System.out.printf("%1$-5s", v);
        }
        System.out.println();   
    }
}