public void Esercizio8(){ 
    int alt = 5; 
    int base= 10;

    for(int i=0; i<alt; i++){

        for(int j=0; j<base; j++) {

            if (i == 0 || j == 0 || i == alt-1 || j == base-1)
                System.out.print("*");
            else    
                System.out.print("Q");
        }
        System.out.println();
    }
}