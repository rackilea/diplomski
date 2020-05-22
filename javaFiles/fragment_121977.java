int insertAfter = 2;
// I am assuming the list contains > `insertAfter` elements
ListNode cur = head;
while(insertAfter > 1) {
    cur = cur.next;
    insertAfter--;
}