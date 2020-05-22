Deque<Character> var = new LinkedList<>();

// add elements to queue
var.addAll(Arrays.asList('A', 'B', '*', 'C', 'D', '*', 'E'));

// remove '*' elements and immediately preceding element
for (Iterator<Character> i = var.descendingIterator(); i.hasNext(); ) {
    if (i.next() == '*') {
        i.remove();
        i.next(); // next() when descending actually means previous queue element
        i.remove();
    }
}

System.out.println(var); // prints: [A, C, E]