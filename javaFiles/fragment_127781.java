try {
    my_int_array = addInt(my_int_array, scanner);
}
catch (InputMismatchException ime) {
     // tell that it's not a digit - number
}
catch (IllegalArgumentException iae) {
     // tell that it's a negative input
}
catch (Exception e) {
     // to catch all other exceptions from the Scanner class like IllegalStateException ...
}