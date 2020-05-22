if(object.prev == beginMarker){
    beginMarker.next = object.next.prev; 
    //                             ^^^^ 
    //                             is it here ? object.next is null in your case
    object.next.prev = beginMarker;
}