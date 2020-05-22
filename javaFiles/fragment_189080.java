protected void doStep(String input) {
    if (botPos != null) {

        switch (botPos.getDirection().toLowerCase()) {
            case "up":
                botPos.setY(botPos.getY() - 1);
                break;
            case "down":
                botPos.setY(botPos.getY() + 1);
                break;
            case "left":
                botPos.setX(botPos.getX() - 1);
                break;
            case "right":
                botPos.setX(botPos.getX() + 1);
                break;
        }
        System.out.println(botPos);

    } else {

        System.out.println(" > Invalid state, you have no start position");

    }
}