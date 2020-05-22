if (numberAmount > 15 || numberDigit > 15) {
    System.out.println("We can't generate that many numbers!");
    return true;
} else if (numberAmount < 0 || numberDigit < 0) {
    System.out.println("We can't generate negative amount of numbers!");
    return true;
} else if (numberAmount == 0 || numberDigit == 0) {
    System.out.println("Zero numbers requested");
    return true;
}
return false;