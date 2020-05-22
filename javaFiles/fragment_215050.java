final HashMap<Double, HashMap<Double, Double>> data = new HashMap<Double, HashMap<Double, Double>>();

Double prev = null;
for (final HashMap<Double, Double> nestedMap : data.values()) {
    for (final Double value : nestedMap.values()) {
        if (prev == null) {
            prev = value;
            continue;
        }
        prev = Math.max(value, prev);
    }
}

System.out.println("The max value is " + prev);