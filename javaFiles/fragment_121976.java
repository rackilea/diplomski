int numItems = 5;
ListNode head = null;

Scanner sc = new Scanner(System.in);

while(numItems != 0) {

    // take input from user
    int val = sc.nextInt();

    // list is currently empty
    if(head == null) 
        head = new ListNode(val, null);
    else {
        // go the last node in the list
        ListNode cur = head;
        while(cur.next != null)
            cur = cur.next;

        // cur now points to the last node in the list
        // can add new ListNode here
        cur.next = new ListNode(val, null);
    }
    numItems--;
}