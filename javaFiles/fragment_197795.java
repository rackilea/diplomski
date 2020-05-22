List<Integer> stack = new ArrayList<Integer>();

public int multiply() {
    int x = 0;
    for (int i = 0; i < stack.size(); i++) {
        x *= stack.get(i);
    }
    return x;
}