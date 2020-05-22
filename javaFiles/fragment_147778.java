class Discount {
    private final List<Tier> tiers = List.of(
        new Tier(0.0, 0), new Tier(8.0, 5), new Tier(8.5, 10), new Tier(9.0, 20));

    private class Tier {
        private final double gpa;
        private final int discount;
    }

    private int discount(double gpa) {
        return tiers.stream().filter(t -> t.gpa <= gpa)
            .mapToDouble(t -> t.discount).max().getAsDouble();
    }

    public double tuition(double gpa, double base) {
        return (1.0 - discount(gpa)/100.0) * base;
    }

    public String discountMessage(double gpa) {
        if (discount(gpa) == 0)
            return "You have no discount";
        else
            return "Your discount is " + discount(gpa) + "%";
    }
}