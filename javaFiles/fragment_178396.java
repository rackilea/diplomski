List<Integer> input = Arrays.asList(1, 2, 7, 2, 3, 3, 4, 4, 5);
Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

for (int i=0; i < input.size(); ++i) {
    int val = input.get(i);
    Integer count = (counts.get(val) == null) ? 0 : counts.get(val) + 1;
    input.set(i, count);
    counts.put(val, count);
}

System.out.println(input);