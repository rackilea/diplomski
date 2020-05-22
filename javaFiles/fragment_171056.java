// create a new ListNode object with content 0, and put a reference to it
// in 'result'. At this stage it's 'next' field is null.
ListNode result = new ListNode(0);

s = 7;

// create a new ListNode object with content 7 and a null 'next' field,
// and make the first ListNode object's 'next' field refer to it.
result.next = new ListNode(s);

// now lose the reference to the first object, and instead make 'result'
// point to the second object. At this stage its 'next' field is still null.
result = result.next;

// now print the contents of the 'next' field of the second object, which
// will be null.
System.out.println(result.next);