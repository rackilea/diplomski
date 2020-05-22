public void deleteLink(String data){
    if(isEmpty()){
        System.out.println("The list is empty.");
        System.exit(0);
    }
    else{
        if (firstLink.getData().equals(data)) {
            firstLink = firstLink.next;
        } else {
            Link current = firstLink.next;
            Link previous = firstLink;
            while(current != null){
                if(current.getData().equals(data)){
                    previous.next = current.next;
                    break;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        }
    }
}