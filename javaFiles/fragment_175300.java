int multiply(int a, int b) {
    if(b==0){
        return 0;
    } else if (b > 0){
        return a + multiply(a, b-1)
    } else { // b < 0; 
        return -a + multiply(a, b+1)
    }
}