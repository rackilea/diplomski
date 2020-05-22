public void turn() {
    System.out.print("Move (l/r/p/d): ");
    move = Global.keyboard.nextLine();

    if (move.equals("p") && player.getPosition() == jar1.getPosition()) {

        player.setStone(jar1.getStone());
        jar1 = new Jar(1, null);
    }
}