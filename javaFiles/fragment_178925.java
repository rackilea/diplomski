class Position {
    final int x;
    final int y;
}

interface Positionable {
    Position getPosition();
}

class Entity implements Positionable {
    private Position p;
    public Position getPosition() {
        return position;
    }
}