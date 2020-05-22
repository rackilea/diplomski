for (int i = 0; i < steps; i++){
    double z = (int)(Math.random()*4); 
    if (z == 0) {
        x++;
    } else if (z == 1){
        y++;
    } else if (z == 2){
        x--;
    } else if (z == 3){ 
        y--;
    }
    System.out.println("(" + x + "," + y + ")");        
}