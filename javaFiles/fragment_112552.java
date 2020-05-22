// Slot class and sample data are taken from @Andreas answer
List<Slot> slots = Arrays.asList(new Slot(3, 5), new Slot(5, 7), 
                new Slot(8, 10), new Slot(10, 11), new Slot(11, 13));

List<Slot> result = StreamEx.of(slots)
        .intervalMap((s1, s2) -> s1.end == s2.start,
                     (s1, s2) -> new Slot(s1.start, s2.end))
        .toList();
System.out.println(result);
// Output: [3-7, 8-13]