int[] t = {6, -1, -1, -1, 4, 5, 3, -1, -1};
List<Integer> sorted = IntStream.of(t).boxed()
        .sorted((a, b) -> (a > -1 ? 1 : 0) - (b > -1 ? 1 : 0))
        .collect(Collectors.toList());
for (int i = 0; i < t.length; i++)
    t[i] = sorted.get(i);
System.out.println(Arrays.toString(t));