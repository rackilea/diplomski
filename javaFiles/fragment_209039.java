for (final Node temp : edges.get(current)){
    if(temp.equals(node2)){
        return true;
    } else {
        stack.push(temp);
    }
}