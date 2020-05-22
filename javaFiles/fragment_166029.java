int[] arr1 = {1, 2, 3, 4, 5};
int[] arr2 = {1, 3};

HashMap<Integer, Boolean> map = new HashMap<>();

for (int i : arr1) {
    for (int j : arr2) {
        if (j == i) {
            map.put(i, true);
            break;
        } else {
            map.put(i, false);
        }
    }
}

System.out.println(Arrays.asList(map));