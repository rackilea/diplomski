private String myDescription = "Soy"
public Soy(Beverage beverage) {
    if (beverage.getDescription().contains(myDescription)) {
        throw new Exception();
}
    this.beverage = beverage;
}