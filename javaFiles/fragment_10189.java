public class Solution {
    public ListNode reverseList(ListNode head) {       
        ListNode nxt = null;
        ListNode lst = null;
        while (head != null)
        {
            nxt = head.next;
            head.next = lst;
            lst = head;
            head = nxt;
        }
        return lst;
    }
}