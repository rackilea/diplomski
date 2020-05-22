package so30544570;

public class ListNode {
    private int val;
    private ListNode next;

    private ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append(val);
        if (next != null) {
            sb.append(" -> ").append(next.toString());
        }
        return sb.toString();
    }

    public int value() {
        int result = val;
        if (next != null) {
            result += 10 * next.value();
        }
        return result;
    }

    public static ListNode valueOf(final int i) {
        ListNode root = new ListNode(i % 10);
        if (i / 10 > 0) {
            root.next = ListNode.valueOf(i / 10);
        }
        return root;
    }
}