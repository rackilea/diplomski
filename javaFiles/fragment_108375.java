String[] examples = {
    "-123--4567",
    "123-4567",
    "-123-4567",
    "123--4567"
};
//                           ┌ group 1:
//                           |┌ zero or one "-"
//                           || ┌ any number of digits (at least one)
//                           || |    ┌ zero or one "-" as separator    
//                           || |    | ┌ group 2
//                           || |    | |┌ zero or one "-"
//                           || |    | || ┌ any number of digits (at least one)
Pattern p = Pattern.compile("(-?\\d+)-?(-?\\d+)");
// iterating over examples
for (String s: examples) {
    // matching
    Matcher m = p.matcher(s);
    // iterating over matches (only 1 per example here)
    while (m.find()) {
        // printing out group1 --> group 2 back references
        System.out.printf("%s --> %s%n", m.group(1), m.group(2));
    }
}