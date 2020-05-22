boolean isRaised = false;

try {
    // Some code
}
catch (Exception e) {
    isRaised = true;
}
finally {
    if (isRaised)
        System.out.println("from catch");
    else
        System.out.println("from try");
}