if (num <= booking.length()) {
    char low = booking.charAt(0);
    char high = booking.charAt(highest);
    System.out.println("There are seats from " + low + " - " + high + ".");
    System.out.println(booking);
} else {
    System.out.println("Sorry, the desired seat amount is not available. The maximum amount on Row is " + booking.length());
}