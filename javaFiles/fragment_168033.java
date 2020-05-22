public static getDayNumber(String name, int userNumber){
    if(userNumber<1)
        return "Invalid Number";
    int dayNumber = 0;
    switch(name){
        case "Monday":
            dayNumber = 1;
        break;
        case "Tuesday":   
            dayNumber = 2;
        break;
        case "Wednesday":
            dayNumber = 3;
        break;
        case "Thursday" : 
            dayNumber = 4;
        break;
        case "Friday":    
            dayNumber = 5;
        break;
        case "Saturday":  
            dayNumber = 6;
        break;
        case "Sunday":    
            dayNumber = 7;
    }
    dayNumber = (dayNumber + userNumber)%7;

    switch (dayNumber){
        case 1: return "Monday";
                break;
        case 2: return "Tuedsay";
                break;
        case 3: return "Wednesday";
                break;
        case 4: return "Thursday";
                break;
        case 5: return "Friday";
                break;
        case 6: return "Saturday"; 
                break;
        case 7: return "Sunday"; 
               break;
        default: return "Invalid Day Provided";
    }
}