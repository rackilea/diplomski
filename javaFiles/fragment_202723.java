//use a boolean to tell the loop to continue or not
boolean cont = true;

do {


    System.out.println("Enter number of grades");

    if (input.hasNextInt()){

        numGrade = input.nextInt();

        //I assume 0 is a valid response (not a negative int)
        if (numGrade <= 0){
            System.out.println("Your number of grades needs to positive! Try again");
            continue;
        }
        else {
            cont = false;
            System.out.println("Your input is valid! Value entered is " + numGrade);
        }
    }
    else {
        System.out.println("You did not enter a number! Try again");
                input.next();
                continue;
    }
}
while (cont);