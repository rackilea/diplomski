int i = 10; 
int j = 0; 
    do { 
    j++; 
    System.out.println("loop:" + j); 
    while (i < 15) {                //line6 
         i++
         i = i + 20; 
         System.out.println(i); 
    } ; 
} while (i < 2); 
System.out.println("i_final:" + i);