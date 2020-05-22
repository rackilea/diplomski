public void deleteLast(){
    if(!isEmpty()){
        Node tmp = first;
        while (tmp.next != null && tmp.next.next != null){
            tmp = tmp.next;
        }
        tmp.next = null;
    }
}