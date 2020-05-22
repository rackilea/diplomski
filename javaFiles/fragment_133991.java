double maxValue = Double.MIN_VALUE;
    double minValue = Double.MAX_VALUE;
    List<Double> allValues = new ArrayList<Double>();
    while (input.hasNextDouble()) {
        double value = input.nextDouble();
        maxValue = Math.max(maxValue, value);
        minValue = Math.min(minValue, value);

        allValues.add(value);
    }

    System.out.println("Highest no. is: " + maxValue);
    System.out.println("Lowest no. is: " + minValue);
    System.out.println("The difference from the highest is:" + (maxValue - minValue));
    for (Double value : allValues) {
        System.out.println("The difference from the highest is:" + (maxValue - value));
    }