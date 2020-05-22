private Node select(Node x, int k) {
    if (x == null) return null; 
    int t = size(x.right); 
    if      (t > k) return select(x.right,  k); 
    else if (t < k) return select(x.left, k-t-1); 
    else            return x; 
}