private int m2(int q) { 
       // Note that q now shadowing static variable q of C2
       p= q+1; // Same as to call C2.p = q + 1
       q= q+3; // Here you addressing m2 input variable and not the static field q
       return q; 
}