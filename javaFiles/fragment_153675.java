Queue<Integer> largest = new PriorityQueue<>(100);

    for (int item : new Random().ints(10000, 0, 100).toArray()) {
        if (largest.size() < 100 || largest.peek() < item) {
            if (largest.size() == 100)
                largest.remove();
            largest.add(item);
        }
    }
    System.out.println(largest);