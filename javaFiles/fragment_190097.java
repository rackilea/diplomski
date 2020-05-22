public class StringMerger {

public static void main(String[] args) {
    System.out.println(isMerge("beautiful", "bauful", "eti")); // true
    System.out.println(isMerge("beautiful", "baufl", "eti")); // false
    System.out.println(isMerge("bbbbb", "bbb", "bb")); // true
    System.out.println(isMerge("xyzxyz", "xyz", "xyz")); // true
    System.out.println(isMerge("xyzxyz", "xyz", "xyzd")); // false
    System.out.println(isMerge("backstreetboy", "beetb", "ackstroy")); // true
    System.out.println(isMerge("Can we merge it? Yes, we can!", "Cn w riYes n!", "aemege t? , weca")); //true
    System.out.println(isMerge("beautifulxyzx", "baufulx", "etixyz")); // true
}

public static boolean isMerge(String s, String part1, String part2) {
    if (s.length() != part1.length() + part2.length()) return false;

    int part1Counter = 0;
    int part2Counter = 0;
    int fullStrLen = s.length();

    int fullStrCounter = 0;

    while (fullStrCounter < fullStrLen) {

        boolean part1match = part1Counter < part1.length() && s.charAt(fullStrCounter) == part1.charAt(part1Counter);
        boolean part2match = part2Counter < part2.length() && s.charAt(fullStrCounter) == part2.charAt(part2Counter);
        if (part1match && part2match) { // if find a match in both substring, we need to find out whichever way works
            boolean decision1 = isMerge(s.substring(fullStrCounter + 1), part1.substring(part1Counter + 1), part2.substring(part2Counter));
            if (decision1) return decision1; // no need to check the second branch if the first branch matches
            boolean decision2 = isMerge(s.substring(fullStrCounter + 1), part1.substring(part1Counter), part2.substring(part2Counter + 1));
            return decision2;
        }
        if (part1match) {
            ++part1Counter;
            ++fullStrCounter;
        } else if (part2match) {
            ++part2Counter;
            ++fullStrCounter;
        } else {
            return false;
        }
    }
    return true;
}