public static void main(String[] args) {
    Stack<Integer> s = new Stack<Integer>();
    Deque<Integer> d = new ArrayDeque<Integer>();
    Queue<Integer> l = new LinkedList<Integer>();

    for (int i : numbers) {
      s.push(i);
      l.offer(i);
      d.push(i);
    }

    System.out.println("Stack: ");
    for(Integer i : s) {
      System.out.println(i);
    }

    System.out.println();
    System.out.println("Queue:");
    for(Integer i : l) {
      System.out.println(i);
    }
    System.out.println();
    System.out.println("Deque:");
    for(Integer i : d) {
      System.out.println(i);
    }
  }