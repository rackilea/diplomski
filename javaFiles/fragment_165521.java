class DList<T> {
    DListNode2<T> head; // Or whatever properties your class contains
}

class DListNode2<T> {
   T runObject;
   DListNode2<T> prev;
   DListNode2<T> next;
}