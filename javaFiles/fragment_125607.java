for(int x=0; x<experiments; x++){
    int heads = 0;
    for(int y=0; y<flips; y++){
        if(rnd.nextInt(2) == 0)    //assume 0 is head    
            heads ++;
    }        
    //print histogram
    for(int y=0; y<heads; y++)
        System.out.print("*");
    System.out.println();
}