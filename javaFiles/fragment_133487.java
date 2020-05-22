public void addLast(E obj){
Node<E> newNode =  new Node<E>(obj);
if(head == null) head = tail = newNode; /*You set the head and tail here*/
if(head.next==null){ /*This is obviously null because you only have one node and based on your node class*/
head.next = tail.next = newNode; /*Yet you add this to your next, giving you an infinite loop, a node whose next is itself*/
tail = newNode;}