void slideRight() {
    for (int row = 0; row < 4; row++) {
        for (int column = 3; column >= 0; column--) {
            Tile current = board[row][column];

            if (current.value == 0) continue;

            for (int slot = column + 1; slot < 3; slot++) {
                Tile target = board[row][slot];

                if (target.value == 0) {
                    target.value = current.value;
                    current = target;
                    board[row][slot - 1].reset();
                } else if (target.value == current.value) {
                    Tile product = target.merge(current);

                    if (!target.collided && !current.collided) {
                        current = product;
                        board[row][slot - 1].reset();
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}