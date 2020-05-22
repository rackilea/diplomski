for(int i=0;i<7;i++){ 
    for(int j=0;j<3;j++){
        if(j == 0) {
            System.out.print(i+1+" ");  
        }
        if(j == 1) {
            System.out.print(i+1+7+ " ");   
        }
        if(j == 2 && i < 2) {
            System.out.print(i+1+14);   
        }
    } 
    System.out.println("");
}