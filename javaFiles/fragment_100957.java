if(num == -2) {
    System.out.print("end");
} else if (num >= 0 && num < sourcetext.lenght()) {
    // index ok
    result2 = sourcetext.charAt(num); // num converted into characters
    System.out.print(result2);
} else {
    // index out of bounds
    System.out.print("!");
}