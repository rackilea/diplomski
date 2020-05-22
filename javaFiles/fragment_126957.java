double min=Double.MAX_VALUE, max=Double.MIN_VALUE;
for (double[] ds : values) {
    for (double d : ds) {
        if (d > max) max=d;
        if (d < min ) min=d;

    }
}