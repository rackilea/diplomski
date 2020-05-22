if (in.hasNextInt()) {
    zip = in.nextInt(); // asking for input once
    if (zip > 999 && zip < 100000) {
        zip = in.nextInt(); // if validates, you're asking for input again
    } else {
        System.out.println("Incorrect length for a zip. Try again");
        System.out.print("Enter zipcode: ");
        continue;
    }
    shallNPass = false;
}