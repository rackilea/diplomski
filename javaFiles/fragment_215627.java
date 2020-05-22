import java.util.ArrayList;

public class Board {
    private ArrayList<Battleship> battleships = new ArrayList<Battleship>();

    public Board() {
        battleships.add(new Battleship("Battleship", 0, 5));
        battleships.add(new Cruiser("Cruiser", 1));
        battleships.add(new Minesweeper("Minesweeper", 2));
    }

    public boolean hit(int row, int column) {
        for (Battleship b : battleships) {
            if (b.hit(row, column) == true) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Board board = new Board();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board.hit(i, j);
            }
        }
    }

}

class Battleship {
    private Part[] part;
    private String name;

    public Battleship(String name, int row, int sizeofTheShip) {
        this.name = name;
        part = new Part[sizeofTheShip];
        for (int i = 0; i < sizeofTheShip; i++) {
            part[i] = new Part(row, i);
        }
    }

    public boolean hit(int row, int column) {
        System.out.printf("%s: %s%n", getName(), "From Battleship");
        Part newpart = new Part(row, column);
        for (int i = 0; i < part.length; i++) {
            if (part[i].equals(newpart)) {
                part[i].setDestroyed(true);
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

}

class Cruiser extends Battleship {
    public Cruiser(String name, int row) {
        super(name, row, 4);
    }
}

class Minesweeper extends Battleship {
    public Minesweeper(String name, int row) {
        super(name, row, 2);
    }

    @Override
    public boolean hit(int row, int column) {
        System.out.printf("%s: %s%n", getName(), "From Minesweeper");
        double random = Math.random();
        if (random > 0.5) {
            super.hit(row, column);
            return true;
        } else {
            return false;
        }
    }
}

class Part {
    private int row;
    private int i;
    private boolean destroyed;

    public Part(int row, int i) {
        this.row = row;
        this.i = i;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public int getRow() {
        return row;
    }

    public int getI() {
        return i;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public String toString() {
        return "Part [row=" + row + ", i=" + i + ", destroyed=" + destroyed + "]";
    }
}