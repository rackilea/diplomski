System.out.println("Please type 1 for game 1 or 2 for game2:");
            action = Integer.parseInt(br.readLine());
            if (action == 1)
            {
                System.out.println("\nYou have chosen to game 1");
                Game1 game1 = new Game1();
                game1.start();
            }
            else if (action == 2)
            {
                System.out.println("\nYou have chosen game 2");
                Game2 game2 = new Game2();
                game2.start();
            }