if (taxable >= 1 && taxable <= 9075){
        taxrate = (int) (taxable * .10);
} else if (taxable >= 9076 && taxable <= 36900) {
        taxrate = (int) ((taxable - 9076) * .15)  + 908;
} else if (taxable >= 36901 && taxable <= 89350) {
    taxrate = (int) ((taxable - 36901) * .25)  + 5082;
} ...