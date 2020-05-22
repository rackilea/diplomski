public class Battlefield {

    Cell[][] cells;

    public Battlefield(int size) {
        this.cells = new Cell[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                cells[x][y] = new Cell();
            }
        }
    }

    public void add(Ship ship) {
        int start = ship.horizontal ? ship.x : ship.y;
        for (int i = 0; i < ship.size(); i++) {
            cells[ship.horizontal ? i + start : ship.x][ship.horizontal ? ship.y : i + start] = ship.getSegment(i);
        }
    }

    public void remove(Ship ship) {
        int start = ship.horizontal ? ship.x : ship.y;
        for (int i = start; i < start + ship.size(); i++) {
            cells[ship.horizontal ? i : ship.x][ship.horizontal ? ship.y : i] = new Cell();
        }
    }

    public boolean shoot(int x, int y) {
        return cells[x][y].shoot();
    }

}

public class Cell {

    private boolean isShot;

    public Cell() {
        this.isShot = false;
    }

    public boolean isEmpty(){
        return true;
    }

    public boolean isShot(){
        return isShot;
    }

    public boolean shoot() {
        isShot = true;
        return isEmpty();
    }

}

public class ShipSegment extends Cell {

    Ship ship;

    public ShipSegment(Ship ship) {
        super();
        this.ship = ship;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public Ship getShip() {
        return ship;
    }
}

public class Ship {

    int x, y;
    boolean horizontal;
    ShipSegment[] segments;

    public Ship(int x, int y, int size, boolean horizontal) {
        this.x = x;
        this.y = y;
        this.horizontal = horizontal;
        segments = new ShipSegment[size];
        for (int i = 0; i < size; i++) {
            segments[i] = new ShipSegment(this);
        }
    }

    public int size() {
        return segments.length;
    }

    public boolean isDestroyed() {
        for (ShipSegment segment : segments) {
            if (!segment.isShot()) {
                return false;
            }
        }
        return true;
    }

    public ShipSegment getSegment(int index){
        return segments[index];
    }

}