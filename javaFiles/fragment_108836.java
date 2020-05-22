public void movePlayer() {
        if ( pressedKeys.contains( UP ) ) {
            movePlayerUp();
        }
        if ( pressedKeys.contains( DOWN ) ) {
            movePlayerDown();
        }
        if ( pressedKeys.contains( S ) ) {
            movePlayerDown();
        }

        ...

    }