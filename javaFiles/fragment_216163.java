public class Seat {

  public int sectionId;
  public int seatId;

  public Seat(int seatId, int sectionId) {
    this.seatId = seatId;
    this.sectionId = sectionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Seat seat = (Seat) o;
    if (sectionId != seat.sectionId) return false;
    return seatId == seat.seatId;
  }

  @Override
  public int hashCode() {
    int result = sectionId;
    result = 31 * result + seatId;
    return result;
  }
}