public void battle() {
    boolean restart = false;
    do {
        printWelcome();
        while (this.player.isAlive() && this.currentOpponent.isAlive()) {
            String input = reader.getInput();
            if (input.contains("attack")) {
                newRound();
            } else if (input.contains("run")) {
                run();
                break;
            } else if (input.contains("joke")) {
                System.out.println("What did the homeless man get for christmas? Nothing.");
            } else if (input.contains("use")) {
                String itemName = input.replace("use ", "");
                player.useItem(itemName);
            } else if (input.contains("stance " + "")) {
                this.player.setStance(input.split(" ", 2)[1]);
            } else {
                System.err.println("What? Choose 'attack', 'joke' 'use <item>' or 'run'");
            }
        }
        restart = endGame();
    } while (restart);
}