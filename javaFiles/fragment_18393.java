/**
     * A parting is a period of time.
     */
    abstract class Parting {
      final int beginingHour;
      final int endHour;
      public Parting(int beginingHour, int endHour) {
        this.beginingHour = beginingHour;
        this.endHour = endHour;
      }

      public int getBeginingHour() {
        return beginingHour;
      }

      public int getEndHour() {
        return endHour;
      }
    }

    class DayParting extends Parting {
      List<DayPart> dayParts = new ArrayList<DayPart>();

      public DayParting(int beginingHour, int endHour) {
        super(beginingHour, endHour);
      }

      public List<DayPart> getDayParts() {
        return dayParts;
      }
    }

    class DayPart extends Parting {
      List<TimePart> timeParts= new ArrayList<TimePart>();

      public DayPart(int beginingHour, int endHour) {
        super(beginingHour, endHour);
      }
    }

    class TimePart extends Parting {
      public TimePart(int beginingHour) {
        super(beginingHour, beginingHour + 1); // only one hour
      }
    }