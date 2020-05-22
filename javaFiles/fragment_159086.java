String dayOfTheWeek; // Changed from Day to String
String openingTime;
String closingTime;

public SingleOpeningHours(Day dayOfTheWeek,String openingTime, String closingTime){

this.dayOfTheWeek = dayOfTheWeek.name(); // make sure add .name()
this.openingTime = openingTime;
this.closingTime = closingTime;