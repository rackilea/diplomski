public void store2D(int num){
    System.out.println("R: " + r);
    System.out.println("C: " + c);
    c_array[r][c++] = num;
    if(c==5){
        c=0;
        r++;
    }
}