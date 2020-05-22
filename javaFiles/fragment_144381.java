public class PlayerComparator implements Comparator<Player> {
    private String dir; // Populate with constructor
    public int compare(Player a, Player b) {
        int result = nullCheck(a.getClubId(), b.getClubId());
        if(result != 0) {
            return result;
        }
        String aname = a.getClubId().getClubName();
        String bname = b.getClubId().getClubName();
        result = nullCheck(aname, bname);
        if(result != 0) {
            return result;
        }
        result = aname.compareTo(bname);
        if("asc".equals(dir)) {   // No NPE thrown if `dir` is null
            result = -1 * result;
        }
        return result;
    }

    private int nullCheck(Object a, Object b) {
        if(a == null) { return -1; }
        if(b == null) { return 1; }
        return 0;
    }
}