String[] arr = { "a", "b", "c", "a", "b" };

Map<String, List<Integer>> map = new HashMap<>();
for (int i = 0; i < arr.length; i++) {
    if (map.containsKey(arr[i])) {
        map.get(arr[i]).add(i);
    } else {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        map.put(arr[i], list);
    }
}

for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
    if (entry.getValue().size() > 1) {
        int counter = 1;
        for (int i : entry.getValue()) {
            arr[i] += counter++;
        }
    }
}
System.out.println(Arrays.toString(arr));