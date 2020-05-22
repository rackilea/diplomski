String yearString1 = "";
String yearString2 = "";
    switch (year) {
        case 1: yearString1 = "First Year";
                yearString2 = "Freshmen";
                break;
        case 2: yearString1 = "Second Year";
                yearString2 = "Sophomore";
                break;
        case 3: yearString1 = "Third Year";
                yearString2 = "Junior";
                break;
        case 4: yearString1 = "Fourth Year";
                yearString2 = "Senior";
                break;
        default:
                System.out.println("Invalid Input");
                break;
    }
    System.out.println(yearString1 + "\n " +yearString2);