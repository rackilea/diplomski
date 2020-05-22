public static void main(String[] args) {
    int i=0;
    while(true) {
        i++;
        if (i%100000000 == 0) System.out.println(i);
        if(i==-1){
            break;
        }
    }
}