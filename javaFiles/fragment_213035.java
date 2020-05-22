public Link find(String Name){

    if(isEmpty()) {
        System.out.println("Empty LinkedList");
        return null;
    } 

    Link theLink = firstLink;
    while(theLink != null) {
        if (theLink.Name.equals(Name)) {
            return theLink;
        }

        theLink = theLink.next;
    }

     // looped through the whole list, didn't find anything
    return null;
}