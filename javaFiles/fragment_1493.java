// if (seatNum != 201) { // optional, to neglect seat 201
    System.out.print("Row: "); // yes, I am that lazy...
    if (seatNum <= 0) {
        System.out.println(1);
    } else if ((seatNum <= 200) /* && (seatNum > 0) */) {
        System.out.println(((seatNum - 1)/ 20) + 1);
    } else /* if (seatNum > 200) */ {
        System.out.println(((seatNum - 202) / 15) + 11);   
    }
// }