package x;
class ListNode{
    ListNode next;
    int data;
    ListNode(){
        data = -1;
    }
    ListNode(int d){
        data = d;
    }
    public void append(int data) {
        ListNode newNode = new ListNode (data);
        if(this.next == null){
            this.next = newNode;
            return;
        }
        ListNode curr = this.next;
        while(curr.next != null)
            curr = curr.next;
        curr.next = newNode;
    }
    public void insert(int data) {
        ListNode newNode = new ListNode (data);
        newNode.next = this.next;
        this.next = newNode;
    }
    public void show(){
        ListNode node = this.next;
        while(node != null){
            System.out.println(node.data);
            node = node.next;
        }
        System.out.println();
    }
    public void swap(){
        ListNode node1;
        ListNode node2;
        ListNode prev;
        prev = this;
        while(true){
            node1 = prev.next;
            if(node1 == null)
                break;
            node2 = node1.next;
            if(node2 == null)
                break;
            node1.next  = node2.next;
            node2.next  = node1;
            prev.next   = node2;
            prev        = node1;
        }
    }
}


public class x {

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.append(4);
        head.append(5);
        head.append(6);
        head.append(7);
        head.insert(3);
        head.insert(2);
        head.insert(1);
        head.insert(0);
        head.show();
        head.swap();
        head.show();
    }
}