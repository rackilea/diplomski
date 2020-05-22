public class Freq<N extends Number & Comparable<N>> implements Comparable<Freq<N>> {

  private final N frequency;

  public Freq(N frequency) {
    if (frequency == null) {
      throw new IllegalArgumentException("frequency must be non-null");
    }
    this.frequency = frequency;
  }

  public int compareTo(Freq<N> other) {
    return frequency.compareTo(other.frequency);
  }
}