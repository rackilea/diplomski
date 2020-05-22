public static void main(String[] args) {
    //Test input
    System.out.println(answer("<-->-<--<>-<<-->--<-->"));
    System.out.println(answer("<<><>><>><<><>>>"));
    System.out.println(answer(">----<"));
    System.out.println(answer("<<>><"));
}

public static int answer(String s) {

    int meetings = 0;

    for (int index = 0; index < s.length() - 1; index++) {    // stop one short of the end, since if the last minion is heading right, there won't be anyone in from of him
        if (s.charAt(index) == '>') {
            meetings += countApproachingMinions(s.substring(index + 1));
        }
    }

    return meetings * 2;
}

private static int countApproachingMinions(String hallwayAhead) {
    return hallwayAhead.replaceAll(">", "")    // ignore minions heading the same way
            .replaceAll("-", "")               // ignore spaces
            .length();                         // count the approaching minions
}