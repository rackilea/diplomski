List<String> input = Arrays.asList("a", "b", "c", "d", "e");
    List<String> output = new ArrayList<>();

    Deque<String> deque = new ConcurrentLinkedDeque<>(input);
    for (String s : deque) {
        output.add(s);
        if (s.equals("c")) {
            deque.addFirst("XXX");
            deque.removeLast();
        }
    }