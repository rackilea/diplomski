public class Node() {
    int value; //node's value
    int counter = 1; //how many items of same type at node
    Node leftChild = null;
    Node rightChild = null;

    public Node(int value) {
        this.value = value;
    }


    public void insert(int newValue) {
        if(newValue > value) {
            if(rightChild != null)
                rightChild.insert(newValue); //we tell the child to deal with it
            else
                rightChild = new Node(newValue); //we make it a child
        }
        else if(newValue < value) {
            if(leftChild != null)
                leftChild.insert(newValue);
            else
                leftChild = new Node(newValue);
        }
        else if(newValue == value) {
            counter++; // we found a duplicate, increase count
        }
    }
}