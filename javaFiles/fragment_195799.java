package cruft;

import java.util.Date;

/**
 * Equals and hashCode test
 * Creation date 1/16/2016.
 * @link https://stackoverflow.com/questions/34826585/hashcode-changes-each-time-the-object-is-created
 */
public class OverrideDemo {

    private long timestamp;
    private int damage;
    private SquareType squareType;


    public OverrideDemo(int damage, SquareType squareType) {
        this(damage, squareType, new Date().getTime());
    }

    public OverrideDemo(int damage, SquareType squareType, long timestamp) {
        if (squareType == null) throw new IllegalArgumentException("square type cannot be null");
        this.timestamp = timestamp;
        this.damage = damage;
        this.squareType = squareType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getDamage() {
        return damage;
    }

    public SquareType getSquareType() {
        return squareType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        OverrideDemo that = (OverrideDemo) o;

        if (damage != that.damage) { return false; }
        return squareType == that.squareType;

    }

    @Override
    public int hashCode() {
        int result = damage;
        result = 31 * result + squareType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OverrideDemo{" +
                "timestamp=" + timestamp +
                ", damage=" + damage +
                ", squareType=" + squareType +
                '}';
    }
}

enum SquareType { FIRE, WIND, WATER, EARTH }