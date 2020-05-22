for(i=1; i<=side;i++){

        for (k1=0; k1 < (side-i/2);k1++){
            System.out.print("    ");
        }
        for(j=1;j<=i;j++){

            if(i%2 ==0 && j ==1){
                System.out.print("  ");
            }
            System.out.print(fill + "    ");
        }
        System.out.println('\n');
    }