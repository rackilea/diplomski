class ListNode {
    int value;
    ListNode next;
    public ListNode(int value) {
        super();
        this.value = value;
    }
}

public class Test {

    public static ListNode copy(ListNode list){
        if (list == null)
            return null;

        ListNode res = new ListNode(list.value);
        ListNode resTmp = res;
        ListNode listTmp = list;

        while (listTmp.next != null){
            listTmp = listTmp.next;
            resTmp.next = new ListNode(listTmp.value);
            resTmp = resTmp.next;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode input = new ListNode(11);
        input.next = new ListNode(12);
        input.next.next = new ListNode(13);

        ListNode output = copy(input);

        while (output != null){
            System.out.println(output.value);
            output = output.next;
        }
    }

}