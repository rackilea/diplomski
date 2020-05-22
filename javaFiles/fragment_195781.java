public class Seat {

    private final int row;
    private final int number;
    private boolean reserved = false;

    public Seat(int row, int number) {
        this.row = row;
        this.number = number;
    }

    public boolean reserve() {
        if (!reserved) {
            reserved = true;
            return reserved;
        }
        return !reserved;
    }

    public int getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    public boolean isReserved() {
        return reserved;
    }

    public boolean is(int row, int number) {
        return this.row == row && this.number == number;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.row;
        hash = 23 * hash + this.number;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Seat other = (Seat) obj;
        if (this.row != other.row) {
            return false;
        }
        return number == other.number;
    }
}