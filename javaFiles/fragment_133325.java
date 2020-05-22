start.setOnMouseClicked(e -> {

    pane.getChildren().removeAll(lines);
    lines.clear();
    initialX = latticeSize * scale / 2;
    initialY = latticeSize * scale / 2;

    currentX = initialX;
    currentY = initialY;

    AnimationTimer timer = new AnimationTimer() {

        long prevTime = 0;

        @Override
        public void handle(long now) {

            // some delay
            if ((now - prevTime) < 50_000_000) {
                return;
            }

            prevTime = now;

            if (noNodeTouchesBorders() && validMoveExists()) {

                // Check which directions are empty
                buildValidMovesList();

                // Choose from the available directions
                chosenDirection = moveDirections.get(random.nextInt(moveDirections.size()));

                // Make the move
                makeMove();

                // Reset list of possible moves
                moveDirections = new ArrayList<>();

            } else {

                stop();

                System.out.println("Finished walk.");

                if (noNodeTouchesBorders()) {
                    System.out.println("Dead end.");
                } else {
                    System.out.println("Reached exit.");
                }
            }

        }
    };

    timer.start();

});