for(int i=0; i< 40; i++) {
        System.out.println("i = "+i);
        for(int j=0; j< 42; j++) {   //dont do j=i
           System.out.println("j = "+(j+i*42));
        }
    }