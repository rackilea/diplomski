int a = 6;
for (int i=0; i < a ; i++) {
    for (int j=0; j<=i; j++) {
        char chr = (i == a-1 || j == 0 || j == i) ? '*' : ' ';
        System.out.print(chr); 
    } 

    System.out.println(); 
}

*
**
* *
*  *
*   *
******