System.out.println("It's not correct..Try Again, " + name + ".");

do {
    if (age < 16) {
        System.out.println("You can't visit in the museum, " + name + ".");

        if (age < 18);
        System.out.println("You can't visit in the park, " + name + ".");
    }
    if (age < 25) {
        System.out.println("You can't visit if you have a car, " + name + ".");
    }
    if (age >= 25) {
        System.out.println("You can do anything, "
                + name + ".");

    }
    //while(age > 300);<<----------wrong position 

    System.out.println("It's not correct..Try Again, " + name + ".");

} while (age > 300);//<<----------correct position