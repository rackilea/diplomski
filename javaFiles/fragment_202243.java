public class Uid {
    private static final Pattern USER_ID_PATTERN = Pattern.compile("userId\":\\d+");
    private static final String GENERATED_USER_ID = "userId\":622";
    public static void main(String[] args) {

        List<String> jsonData = new ArrayList<String>();
        jsonData.add("[{\"lv\":[{\"v\":{\"nt\":\"10;1341943000000\",\"userId\":621},\"cn\":0},{\"v\":{\"nt\":\"20;1234567890123\",\"userId\":622},\"cn\":0},]"); // this string contains multiple uids

        for (String s : jsonData) {
            Matcher matcher = USER_ID_PATTERN.matcher(s);
            while (matcher.find()) {
                String currentUid = matcher.group();
                 if (!currentUid.equals(GENERATED_USER_ID))
                    System.out.println("LOG exception, " + currentUid + " doesn't exists");

            }
        }
    }
}