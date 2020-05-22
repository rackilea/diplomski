switch (month) {  
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            if (day > 31)
                System.out.print(date + " is an invalid date.");
            else 
                System.out.print(date +  " is a valid date.");
            break;  // Here

        case 4:
        case 6:
        case 9:
        case 11:
            if (day > 30)
                System.out.print(date + " is an invalid date.");
            else 
                System.out.print(date +  " is a valid date.");
            break;  // Here

        case 2:
            if (year % 4 == 0)
                if (day > 29)
                   System.out.print(date + " is an invalid day.");
                else
                   System.out.print(date + " is a valid date and leap year.");
            else
                if (day > 28)
                    System.out.print(date + " is an invalid day.");
                else
                   System.out.print(date + " is a valid date.");
            break;  // Here

        default:
            System.out.println("The date: " + date + " has an invalid month");

    }