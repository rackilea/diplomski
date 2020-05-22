for (Domino current : dominos) {
        if (previous != null) {
            if (current.getLeftValue() != previous.getRightValue()) {
                System.out.println("[" + previous.getLeftValue() + " " + previous.getRightValue()
                        + "][" + current.getLeftValue() + " " + current.getRightValue() + "] is illegal");
            } else {
                System.out.println("[" + previous.getLeftValue() + " " + previous.getRightValue()
                        + "][" + current.getLeftValue() + " " + current.getRightValue() + "] is legal");
            }
        }
        previous = current;
    }