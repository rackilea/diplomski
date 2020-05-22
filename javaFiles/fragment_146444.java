private static double getDollars(
        final int type,
        final int value) {
    switch (type) {
        case 0: // Penny
            return value / 100D;
        case 1: // Nickle
            return value / 20D;
        case 2: // Dime
            return value / 10D;
        case 3: // Quarter
            return value / 4D;
        case 4: // Half
            return value / 2D;
        case 5: // Dollar coin
        case 6: // Dollar bill
            return value;
        case 7: // Two dollars bill
            return value * 2D;
        case 8: // Five dollars bill
            return value * 5D;
        case 9: // Ten dollars bill
            return value * 10D;
        case 10: // Twenty dollars bill
            return value * 20D;
        case 11: // Fifty dollars bill
            return value * 50D;
        case 12: // A hundred dollars bill
            return value * 100D;
        default:
            return 0;
    }
}