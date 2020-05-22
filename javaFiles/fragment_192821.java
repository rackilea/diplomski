public class Logtest {

    String logPattern_orig = ".*(userName:)(\\S+)\\s(userId:)(\\S+)\\s(session:)(\\S+)\\s(searchString:)([^,]).*";
    String logPattern = ".*userName:(\\S+)\\suserId:(\\S+)\\ssession:(\\S+)\\ssearchString:([^,]*),.*";

    String kafkaMsg = "userName:User.Name userId:FDF3JH4 session:9cf2-21-c6-28-c360f1edba53 searchString:test, searchType:DEFAULT_SEARCH";

    void test() {
        final Pattern p = Pattern.compile(logPattern);
        Matcher matcher = p.matcher(kafkaMsg);

        if (matcher.matches()) {
            System.out.println("Matches!");
            for (int i=1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + "='" + matcher.group(i) + "'");
            }
        }

    }

    public static final void main(String[] args) {
        Logtest lt = new Logtest();
        lt.test();
    }

}