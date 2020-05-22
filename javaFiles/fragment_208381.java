...
int a[] = new int[10];
Map<Integer, Integer> count = new HashMap<>();

for (int i = 0; i < a.length; i++) {
    a[i] = (int) (Math.random() * 10);
    count.compute(a[i], (k, ov) -> ov != null ? ++ov : 1);
}

List<Entry<Integer, Integer>> repetitions = count.entrySet().stream()
                                             .filter(e -> e.getValue() > 1)
                                             .collect(Collectors.toList());

// Return the value & or display the details
if (repetitions.isEmpty()) {
    System.out.println("No repetition found !");
} else {
    System.out.println("Number of value which are repeated : " + repetitions.size());
    repetitions.forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue() + " times"));
}
...