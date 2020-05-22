int[] unsorted = { -3, 95, -4, 20, 5, 6, 8 };

PriorityQueue<Integer> q = new PriorityQueue<>(unsorted.length);

for (int a : unsorted) {
    if (a > 0)
        q.add(a);
}

while (!q.isEmpty()) {
    System.out.println(q.poll());
}