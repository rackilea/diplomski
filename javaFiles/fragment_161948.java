class Player {
    String name;
    Location loc;
    List<Item> inventory;

    void pickup() {
        if (itemsOnGround.isEmpty()) {
            throw new InvalidActionException("There appears to be nothing to pick up here");
        }
        inventory.add(loc.itemsOnGround.get(0));
        loc.itemsOnGround.remove(0);
    }
}

class Location {
    List<Items> itemsOnGround;

    /** null if there isn't a monster here */
    Monster monster;
}

class Game {
    Player player;
}

class Ui {
    Game game;

    void keypressed(char key) {
        try {
            if (key == 'p') {
                game.player.pickup();
            } else {
                showKeyboardHelp();
            }
        } catch (InvalidActionException e) {
            showErrorMessage(e.getMessage());
        }
    }
}