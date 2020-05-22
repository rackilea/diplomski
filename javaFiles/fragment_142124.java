class Pizza {

    @MaxGramsOfCheese(max = "${application.pizza.cheddar.max-grams}")
    int gramsOfCheddar;

    @MaxGramsOfCheese(max = "${application.pizza.mozerella.max-grams}")
    int gramsOfMozerella;

}