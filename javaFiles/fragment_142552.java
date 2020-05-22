public ChartValue(String name, Color color, double ... values) {
    this.name = name;
    this.values = values;
    this.color = color;

    // at this point, "values" is just an array of doubles.
    System.out.println("Got " + values.length + " values.");
    for (double value : values) {
        System.out.println("Passed in " + value);
    }
}