String str = "A34B56A12B56";

// pattern that captures the prefix and the suffix groups
String regexStr = "([A-z]+)([0-9]+)";
// compile the regex pattern
Pattern regexPattern = Pattern.compile(regexStr);
// create the matcher
Matcher regexMatcher = regexPattern.matcher(str);

HashMap<String, ArrayList<Long>> prefixToNumsMap = new HashMap<>();
// retrieve all matches, add to prefix bucket
while (regexMatcher.find()) {
    // get letter prefix (assuming can be more than one letter for generality)
    String prefix = regexMatcher.group(1);
    // get number
    long suffix = Long.parseLong(regexMatcher.group(2));

    // search for list in map
    ArrayList<Long> nums = prefixToNumsMap.get(prefix);
    // if prefix new, create new list with the number added, update the map
    if (nums == null) {
        nums = new ArrayList<Long>();
        nums.add(suffix);
        prefixToNumsMap.put(prefix, nums);

    } else { // otherwise add the number to the existing list
        nums.add(suffix);
    }

    System.out.println(prefixToNumsMap);
}