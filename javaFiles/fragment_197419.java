Player player1 = new Player(); //player1.isSunk is false
Player player2 = new Player(); //player2.isS1Sunk is again false,
                               //and separate from player1.isS1Sunk
player1.hitownshiporGrenade(foo, bar) //This changes player1.isSunk to true
System.out.print(player1.getIsSunk());    //true, assuming lucky hits
System.out.print(player2.getIsSunk());    //false