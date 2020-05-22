public static void main(String[] args) {
    System.out.println(x("12 + 3"));
    System.out.println(x("12 * 3"));
    System.out.println(x("12 [ 3"));
}

// Static for example purposes
public static Double x(String x){

    String[] parsed;
    if (x.contains("*")) {
        // * Is a special character in regex
        parsed = x.split("\\*");

        return Double.parseDouble(parsed[0]) * Double.parseDouble(parsed[1]);
    }
    else if (x.contains("+")) {
        // + is again a special character in regex
        parsed = x.split("\\+");

        return Double.parseDouble(parsed[0]) + Double.parseDouble(parsed[1]);
    }

    return null;
}