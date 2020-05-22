public class Test2 {

SListNode head;

public void insertEnd(String item) {
    SListNode current = head;
    while (current.next != null) {
        current = current.next;
    }
    current.next = new SListNode(item);
    // this line does not have any meaning, because it is out of while loop scope
    current = current.next;

}

public static void main(String[] args) {
    Test2 test2 = new Test2();
    test2.test();

}

private void test(){
    // keeping head reference
    head = new SListNode("1");
    insertEnd("2");
    insertEnd("3");
    insertEnd("4");

    System.out.println("HEAD "+head.item);
    SListNode init = head.next;
    while ( init != null ){
        System.out.println("ADDED "+init.item);
        init = init.next;
    }
  }

class SListNode {
    SListNode next;
    String item;
    public SListNode(String item) {
        this.item = item;
    }
}