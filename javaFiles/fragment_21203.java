List<Fraction> listOfFractions = new ArrayList<>();

    for (int i = 1; i <= 5; i++) {
        int num = 1 + random.nextInt(5);
        int denum = 1 + random.nextInt(5);
        Fraction fractionObj = new Fraction(num, denum);
        listOfFractions.add(fractionObj); //add the object to your list
    }