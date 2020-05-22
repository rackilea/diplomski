for(int i = 0;i < values.length; i++) {
    double income = values[i];
    double tax = one.tax(income);

    Bar y = new Bar();
    ...