String patternString = "\\d{2}/\\d{2}/\\d{4}";

Pattern pattern = Pattern.compile(patternString);
Matcher matcher = pattern.matcher(nom);

String output = "";

while (matcher.find()) {
    String get_data = matcher.group();

    String parts[] = get_data.split("/");
    String get_day = parts[0];
    String get_month = parts[1];
    String get_year = parts[2];

    String s = NumberConvert.convert(Integer.parseInt(get_day)) +
               NumberConvert.convert(Integer.parseInt(get_month)) +
               NumberConvert.convert(Integer.parseInt(get_year));

    if (output.equals("")) {
        output = s;
    }
    else {
        output += " +++ " + s;
    }

    String replace = matcher.replaceFirst("");
    matcher = pattern.matcher(replace);
}