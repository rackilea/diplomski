int oddCount;                       // use an instance variable to count the difference between the amount of left odd-nodes and right odd-nodes

public boolean isOddBalanced() { 
    this.oddCount = 0;              // reset count each time balance is calculated to ensure answer is correct each time (and not just on the first call)
    isOddBalancedHelper(root, '0');
    return (this.oddCount == 0);
}

private void isOddBalancedHelper (Node x, char comingFrom) {
    if (x == null) return;
    isOddBalancedHelper(x.left, 'l');  
    isOddBalancedHelper(x.right, 'r'); 
    if(x.value % 2 != 0 && comingFrom == 'l') {        // if current node is odd and a left child
        this.oddCount++;
    } else if(x.value % 2 != 0 && comingFrom == 'r') { // if current node is odd and a right child
        this.oddCount--;
    }
}