String openHour = "08:00 AM";
String currentHour = "01:00 PM";
String closeHour = "02:00 AM";

DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "hh:mm a" , Locale.US );
LocalTime openTime = LocalTime.parse(openHour, formatter);
LocalTime currentTime  = LocalTime.parse(currentHour, formatter);
LocalTime closeTime = LocalTime.parse(closeHour, formatter);

boolean isOpen = false;
if (closeTime.isAfter(openTime)) {
  if (openTime.isBefore(currentTime) && closeTime.isAfter(currentTime)) {
    isOpen = true;
  }
} else if (currentTime.isAfter(openTime) || currentTime.isBefore(closeTime)) {
  isOpen = true;
}

if (isOpen) {
  System.out.println("We are open");
} else {
  System.out.println("We are closed");
}