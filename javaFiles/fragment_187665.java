package so30544570;

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return ListNode.valueOf(l1.value() + l2.value());
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.valueOf(365);
        ListNode l2 = ListNode.valueOf(248);
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);
        System.out.println("l1 + l2 = " + addTwoNumbers(l1, l2));
    }
}