// How many days gone after reference date (a known week-start date)
daysGone  = today - referenceDate;

// A new week starts after each 7 days
dayOfWeek = daysGone % 7;

// Now, we know today is which day of the week.
// We can find start & end days of this week with ease
weekStart = today - dayOfWeek;
weekEnd   = weekStart + 6;