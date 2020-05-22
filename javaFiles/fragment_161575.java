public void shiftLeft() {
        x -= SHIFT_INC;
        for (Point p : cubeOnePoints) {
            p.x -= SHIFT_INC;
        }
        for (Point p : cubeTwoPoints) {
            p.x -= SHIFT_INC;
        }
    }