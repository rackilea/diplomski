do {
    System.out.print("Which city do you want a report for?");
    input = keyboard.next();
    if (checkValidCity(input)) {
        input = city;
    }
    System.out.print("Not a city we consult in, try another...");     
} while (!checkValidCity(input));