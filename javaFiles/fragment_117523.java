class ListNode {

    public ListNode(char element,ListNode next ) {
        this.element = element;
        this.next = next;
    }

    public char element;
    public ListNode next;

    void print() {
        System.out.print(this.element+",");
        if(this.next != null) {
            this.next.print();
        }
        else {
            System.out.println("");
        }

    }

}
public class main {


    //Imo you should only check if this elem is a null one, as a null means empty, a null on next only means that it's the last elem, but will still contain data
    public static boolean isEmpty(ListNode l) {
        return l == null;
    }

    public static ListNode getNextUpper(ListNode head) {
        while(!isEmpty(head)){
            if(Character.isUpperCase(head.element)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public static ListNode copyUpperCase(ListNode head) {
        ListNode newhead = getNextUpper(head);
        ListNode temp = newhead;
        while(!isEmpty(temp)){
            temp.next = getNextUpper(temp.next);
            temp = temp.next;
        }
        return newhead;
    }

    public static void main(String[] args) {
        ListNode t = new ListNode('a' , new ListNode('b' , new ListNode('I', new ListNode('d', new ListNode('R', new ListNode('A', new ListNode('7', new ListNode('p',null))))))));

        t.print();

        ListNode newt = copyUpperCase(t);

        newt.print();
    }

}