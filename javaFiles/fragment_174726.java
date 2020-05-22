private int m1(int p) { 
     // Now static p shadowed by method input parameter
     p= q+1; // Changing p of method input parameter
     q= q+3; // Same as C2.q += 3
     return q; 
}