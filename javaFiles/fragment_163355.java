public class LinkedListNode {
    int data;
    private LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public LinkedListNode getNext() {
        return next;
    }
}

char[] totalNum = (total + "").toCharArray();
int length = totalNum.length;

LinkedListNode tail /*or 'head', whatever suits you*/ = new LinkedListNode(totalNum[length - 1]);
LinkedListNode newNode;
LinkedListNode previousNode = tail;

for (int i = length - 2; i >= 0; i--) {
    newNode = new LinkedListNode(totalNum[i]);
    previousNode.setNext(newNode);
    previousNode = newNode;
}