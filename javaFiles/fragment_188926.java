private static boolean checkOverlap(String a, String b, String c) {
    Boolean[][][] memoize = new Boolean[a.length()+1][b.length()+1][c.length()+1];
    return checkOverlap(a, b, c, 0, 0, 0, memoize);
}
private static boolean checkOverlap(
    String a
,   String b
,   String c
,   int pa
,   int pb
,   int pc
,   Boolean[][][] memoize
) {
    Boolean res = memoize[pa][pb][pc];
    if (res != null) {
        return (boolean)res;
    }
    if (pa == a.length() && pb == b.length() && pc == c.length()) {
        res = true;
    } else if (pc == c.length()) {
        res = false;
    } else {
        res = false;
        if (pa != a.length() && c.charAt(pc) == a.charAt(pa) && checkOverlap(a, b, c, pa+1, pb, pc+1, memoize)) {
            res = true;
        } else if (pb != b.length() && c.charAt(pc) == b.charAt(pb) && checkOverlap(a, b, c, pa, pb+1, pc+1, memoize)) {
            res = true;
        }
    }
    return (memoize[pa][pb][pc] = res);
}