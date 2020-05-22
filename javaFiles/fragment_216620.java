public boolean isOddBalanced() { 
    OddCounter c = new OddCounter();  
    isOddBalancedHelper(root, c, '0');
    return (c.count == 0);
}

private void isOddBalancedHelper (Node x, OddCounter c, char comingFrom) {
    if (x == null) return;
    isOddBalancedHelper(x.left, c, 'l');  
    isOddBalancedHelper(x.right, c, 'r'); 
    if(x.value % 2 != 0 && comingFrom == 'l') {        // if current node is odd and a left child
        c.count++;
    } else if(x.value % 2 != 0 && comingFrom == 'r') { // if current node is odd and a right child
        c.count--;
    }
}