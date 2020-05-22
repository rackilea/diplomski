// Initialize with 0, 1, 2
ArrayList<Long> s = new ArrayList<Long>(Arrays.asList(0L, 1L, 2L));

// Append 3, 4, 5
s.add(3L);
s.add(4L);
s.add(5L);


long[] longArray = new long[s.size()];
for (int i = 0; i < s.size(); i++)
    longArray[i] = s.get(i);