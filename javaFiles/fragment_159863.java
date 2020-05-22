HockeyPlayer player = null;  
do{    
System.out.println(MENU);
choice = input.nextLine();    
switch(choice){
    case "A":
       player = new HockeyPlayer();        
       players[player.getPlayerNumber()-1] = player; 
        break;
    case "G":
       player.addGameDetails(); //invoke the method here for case G
        break;
    case "S":
        break;
    case "X":    
 }

}while(!choice.equals("X"));   
}