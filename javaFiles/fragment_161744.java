String input = "11,22,33,44,55,66,77,88,99";
    Pattern pattern = Pattern.compile(",?(\\d+),");
    Matcher matcher = pattern.matcher(input);
    int counter = 0;
    int wantedMatch = 5;
    while (matcher.find()) {
        counter++;
        if (counter == wantedMatch) {
            String digits = matcher.group(1);
            System.out.println(digits); // prints 55 
            break; // stop searching after n matches.
        }
    }
    if (counter < wantedMatch) {
        System.out.println("You wanted match #" + wantedMatch + ", there only were " + counter);
    }