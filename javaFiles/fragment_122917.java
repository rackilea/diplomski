for(int i = lowest; i <= upper; i++){
    for(int j = 0; j < 5 && i <= upper; i++){
        if(i % 3 == 0 && i % 4 == 0){
            System.out.print(i + "  ");
            j++;
        }
    }
    System.out.println();
}