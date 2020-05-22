boolean hasDeduction = false;

if (distance > 50) {
    if (living == 1) {
        if (work > 1) {
            String error = "You do not get tax deduction because you live alone " +
                           "and your work assigment exceeds 1 year.";
            System.out.println(error); 
        }
        else {
            hasDeduction = true;
        }
    }
    else if (living == 2) {
        if (work > 3) {
            String error = "You do not get tax deduction because you live together ";
                   error += "and your work assigment exceeds 3 years.";
            System.out.println(error); 
        }
        else {
            hasDeduction = true;
        }
    }
}
else {
    String error = "You do not get tax deduction because of your distance ";
           error += "to your work place.";
    System.out.println(error);
}

if (hasDeduction) {
    System.out.println("You get tax deduction");
}