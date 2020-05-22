public void changeCoordination(String wasd)
    Move move = Move.of(wasd);
    // ground[person.getX()][person.getY()] = ground[person.getX() - 1][person.getY()];  
    // Don't know what you're trying to do here but hope you got the idea, just place the coordinate change to `Move`
    ground[person.getX() + move.getCoordinateChange().getX()][person.getY() + move.getCoordinateChange().getY()] = person;
    person.setDir(move.getDirection());
}