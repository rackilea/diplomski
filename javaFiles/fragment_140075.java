String input = "I have the following Car: Chevy, Truck: Ford, Van: Honda";

Pattern p = Pattern.compile("(Car|Truck|Van):\\s*(\\w+)");
Matcher m = p.matcher(input);

while (m.find()) {
    System.out.println(m.group(1) + "\t" + m.group(2));
}