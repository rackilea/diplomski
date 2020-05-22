public static Time add(Time a, Time b) {   // Add two Time(s) together.
  if (a == null) {                         // if a is null, just return b.
    return b;
  } else if (b == null) {                  // if b is null, just return a.
    return a;
  }
  int hours = a.itsHour + b.itsHour;       // Add the hours together.
  int minutes = a.itsMin + b.itsMin;       // Add the minutes together.
  for (; minutes > 59; minutes -= 60) {    // Increment hours as necessary, while
                                           // decrementing the minute count by 60.
    hours++;
  }
  return new Time(hours, minutes);         // Return the new Time instance.
}

public static void main(String[] args) {
  Time now = new Time(7, 30);              // 7:30 in the morning
  Time wait = new Time(2, 45);             // 2 hours 45 minutes
  Time later = Time.add(now, wait);        // produces 10:15 in
                                           // the morning
  System.out.println(later);              
}