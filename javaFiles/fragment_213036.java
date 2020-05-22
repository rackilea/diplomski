public Link find(String Name) {
    if(isEmpty()) {
        System.out.println("Empty LinkedList");
        return null;
    } 
    return findRecur(firstLink, Name);
}

private Link findRecur(Link link, String Name){
    if (link == null) return null;
    if (link.Name.equals(Name)) return link;
    return findRecur(link.next, Name);
}