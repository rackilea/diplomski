if(s.length()==2){
    c = s.charAt(0);
    k = s.charAt(1);
    System.out.println("correct length");

    if((c >= 'A' && c<= 'X')&&(k >= 'A' && k<= 'X')){
        if(board.getGameMap(c).getStatus().equals(color) && board.getGameMap(k).getStatus().equals(".") && BoardGeometry.areConnected(c,k)){
            board.getGameMap(c).setStatus(".");
            board.getGameMap(k).setStatus(color);
            System.out.println("pawn placed");
        }
        else{
            System.out.println("invalid move");
            move();
        }      
    }
    else{
        System.out.println("choose a valid input");
        move();
    }
}
else{
    System.out.println("incorrect length, try again");
    move();
}