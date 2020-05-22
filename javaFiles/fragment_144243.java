outerloop:
for (int i = 0; i < currentPos.length; i++) {
    for (int j = 0; j < currentPos[0].length; j++) {
        if (currentPos[i][j].equals("P")) {
            if (direction.equals("north")) {
                if (currentPos[i - 1][j].equals("---")) {
                    continue;
                } else {
                    currentPos[i][j] = "  ";
                    currentPos[i - 2][j] = "P";

                    break outerloop;

                }
            }
            if (direction.equals("south")) {
                if (currentPos[i + 1][j].equals("---")) {
                    continue;
                } else {
                    currentPos[i][j] = "  ";
                    currentPos[i + 2][j] = "P";

                    break outerloop;

                }
            }
        }

    }
}