while(response == ('y'))
    {
        out.print("Rock-Paper-Scissors - pick your weapon [R,P,S] :: ");
        player = keyboard.next();
        game.setPlayers(player);
        //game.determineWinner();
        out.println(game);
        out.println();
        out.println("would you like to play again? (y/n):: ");
        String resp =  keyboard.next();
        response = resp.charAt(0);
    }