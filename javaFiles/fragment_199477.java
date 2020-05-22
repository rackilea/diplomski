new PriorityQueue<>(
    initialCapacity,
    new Comparator<HuffNode>() {
      @Override public int compare(HuffNode a, HuffNode b) {
        return Integer.compare(a.frequency, b.frequency);
      }
    });