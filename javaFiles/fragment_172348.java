public Node deleteNode(Node focus, int data) {
    if(focus == null) {
        System.out.println("Tree empty");
        return null;
    }
    else if(data < focus.data) {
        focus.leftchild = deleteNode(focus.leftchild, data);
    }
    else if(data > focus.data) {
        focus.rightchild = deleteNode(focus.rightchild, data);
    }
    else {
        // No child
        if(focus.leftchild == null && focus.rightchild == null) {
            focus = null;
        }
        // one child
        else if(focus.leftchild == null) {
            focus = focus.rightchild;
            System.out.println("here");
        }
        else if(focus.rightchild == null) {
            focus = focus.leftchild;
        }
        // 2 children
        else {
            Node temp = findMin(focus.rightchild);
            focus.data = temp.data;
            focus.rightchild = deleteNode(focus.rightchild, temp.data);
        }
    }
    return focus;
}