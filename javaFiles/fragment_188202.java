public void push(int data) {
    root = new StackNode(data, root);
}

public int pop() throws Exception {
    if (root == null)
        throw new Exception("No Elements in Stack");
    else {
        int data = root.data;
        root = root.next;
        return data;
    }
}