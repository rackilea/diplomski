while (!NumsInStack.empty()) {
    if (NumsInStack.peek() > val) {
        System.out.println("woot!");
        break;
    }
    NumsInStack.pop();
}