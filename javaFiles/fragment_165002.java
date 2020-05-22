public class RandomStringUUID {

    private static final String MYUUID = UUID.randomUUID().toString().replaceAll("-", "");

    public static String getRandomStringUUID() { return MYUUID; }
}