public void printMap() {

    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {

            if (player.getPos().equals(x + " " + y)) {
                System.out.print(player.getSymbol());

            } else if (getVampires(x, y)) {
                System.out.print("v");

            } else {
                System.out.print(".");
            }
        }
        System.out.println();
    }

}

public boolean getVampires(int x, int y) {
    for (int v = 0; v < vampires.size(); v++) {
        if (vampires.get(v).getPos().equals(x + " " + y)) {
            return true;
        }
    }

    return false;
}