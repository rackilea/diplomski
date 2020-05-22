String word = "ooffoo";

    word = word.replaceAll("[^A-Za-z0-9]", "");

    Deque<Character> stack = new ArrayDeque<Character>(word.length());
    Deque<Character> queue = new ArrayDeque<Character>(word.length());

    for (char c : word.toCharArray()) {
        stack.push(c);
        queue.add(c);
    }

    boolean pal = true;

    while (! stack.isEmpty() && pal == true) {
        if (! stack.pop().equals(queue.remove())) {
            pal = false;
        }
    }

    System.out.println(pal);