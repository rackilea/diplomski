public int search(E item) {
    return recSearch(item, head, 0);
}

public int recSearch(E item, Node node, int index){
    if (node == null){
        return -1;
    }else if (node.data.equals(item)){
        return index;
    }else{
        return recSearch(item, node.next, index + 1);
    }
}