String[] strs = {
    "Popcorn                   Butter                             6�pkg          3.99",
    "Laundry Detergent         2X Ultra Free Clear                50�oz          11.99"
};

String regex = "\\s+(\\d+)�";
Pattern pattern = Pattern.compile(regex);
for (String str : strs) {
    Matcher matcher = pattern.matcher(str);
    while (matcher.find()) {
        System.out.println(matcher.group(1));
        //                               ^------note to get the group one
    }
}