String total = "Your current total is +$35.25"; 

double amount = getNumberFromString("\\$(\\d+(?:\\.\\d+)?)", total);

public double getNumberFromString(String value, final String s) {
    double n = 0.0;
    Matcher m = Pattern.compile(value).matcher(s);

    while (m.find()) {
        try {
            n = Double.parseDouble(m.group(1));
        }
        catch (Exception ex) {
            n = 0.0;
        }
    }
    return n;
}