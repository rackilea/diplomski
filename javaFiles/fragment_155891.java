public static boolean onFloor;


public void tick() {
    if(Main.isStarted()) {

        floor();

        if(!onFloor) {
            Player.setVelY(20);
        }else {
            Player.setVelY(0);
        }
    }
}

private void floor() {
    clamp(0, 5000, 824, "f");
    clamp(5000, 10000, 750, "p");
}

private void clamp(int start, int stop, int minY, String type) {
    if(x > start && x < stop) {
        if(Player.getY() != minY) {
            if(Player.getY() > minY) {
                if(type != "p") {
                    Player.setY(minY);
                    Player.setVelY(0);
                    onFloor = true;
                    return;
                }
            }
            if(!Player.jumping) {
                Player.setVelY(10);
                onFloor = false;
            }
        }else if(Player.getY() == minY) {
            Player.setY(minY);
            Player.setVelY(0);
            onFloor = true;
        }else if(Player.getY() > minY) {
            if(type != "p") {
                Player.setY(minY);
                Player.setVelY(0);
            }
        }
    }
}