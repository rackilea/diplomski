Set<Integer> chars = new HashSet<>();
String s = /* Your lowercase string */;
s.length() > 25 && s.chars()
    .filter(i -> i >= 'a' && i <= 'z') //only alphabet
    .filter(chars::add)                //add to our tracking set if we reach this point
    .filter(i -> chars.size() == 26)   //filter the 26th letter found
    .findAny().isPresent();            //if the 26th is found, return