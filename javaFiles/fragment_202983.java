double swLatitude = 0.0;
double swLongitude = 0.0;
double neLatitude = 0.0;
double neLongitude = 0.0;

String tokens[] = new String[4];

Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([-?\\d.]+)").matcher(school.getBounds());

int i = 0;
while (m.find()) {
    tokens[i] = m.group(1);
    System.out.println(tokens[i]);
    i++;
}

if (i != 4) {
    throw new IllegalArgumentException(
            String.format("Expected 4 values in bbox string but found %d: %s\n",
                    tokens.length, school.getBounds()));
}

swLatitude =  Double.parseDouble(tokens[0]);
swLongitude = Double.parseDouble(tokens[1]);
neLatitude =  Double.parseDouble(tokens[2]);
neLongitude = Double.parseDouble(tokens[3]);