// Explanations about the regexp:
// \\d+: match the first(s) number(s)
// [\\.,\\s]: match a "separator": a dot, comma or space
// \\d+ (the second one): match the number(s) after the separator.
// The lasts two are englobed in []*, as they can be repeated 0 or n times.
Pattern     patternPrice = Pattern.compile("(\\d+[[\\.,\\s]\\d+]*)");

double extractPrice(String price) throws InvalidParameterException {
    Matcher     matcher = patternPrice.matcher(price);

    if (matcher.find())
    {
        String      match = matcher.group();

        // proceed post treatments to convert the String to a Double
        // delete space from price if any
        if (match.contains(" "))
            match = match.replace(" ", "");

        if (match.contains(","))
        {
            // price contains one comma and one dot: price format is something like that : 1,000,000.00
            // OR
            // there is more than one comma in the price (price is something like that 1,000,000)
            // so delete the , from price
            if (match.contains(".") || match.length() - match.replace(",", "").length() > 1)
                match = match.replace(",", "");
            // price simply use a comma to mark the decimal part, replace it by a . for Double.parseDouble method.
            else
                match = match.replace(",", ".");
        }

        return Double.parseDouble(match);
    }
    else
        throw new InvalidParameterException(price + " is not a valid parameter.");
}