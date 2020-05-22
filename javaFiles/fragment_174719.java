class Data {
  private Calendar calendar;

  Data(Calendar x) { calendar = x; }

  public String whichIsEarlier(Data other) {
    return (calendar.after(other.calendar)? this : other)
        + " jest wczesniej";
  }