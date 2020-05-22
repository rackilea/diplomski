if (input.equals("y")) {
    return true;
}
else if (input.equals("n")) {
    return false;
}
else
{
    System.out.println("Bad input please try again!");
    return keepGoing();
}