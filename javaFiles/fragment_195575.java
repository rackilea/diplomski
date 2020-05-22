private static double convert(String format, double temperature){
    switch(format){
        case "f":
            return toCelsius(temperature);

        case "c":
            return toFahrenheit(temperature);
        default:
            throw new UnsupportedOperationException();
    }
}

private static double toCelsius(double f){
    return 5. / 9. * (f - 32.);
}

private static double toFahrenheit(double c){
    return 9./5. * c + 32.;
}