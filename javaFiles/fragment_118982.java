package range;

public class Range {
    public int min, max;

    public Range(int min, int max) {
        this.min = min; this.max = max;
    }

    public boolean equals(Range other) {
        return this.min == other.min && this.max == other.max;
    }

    public boolean overlaps(Range other) {
        return (min <= other.min && other.min <= max) ||
               (min <= other.max && other.max <= max);
    }

    public void extendBy(Range other) {
        if (other.min < this.min) {
            this.min = other.min;
        }
        if (other.max > this.max) {
            this.max = other.max;
        }
    }

    public String toString() {
        return String.format("[%d, %d]", min, max);
    }
}