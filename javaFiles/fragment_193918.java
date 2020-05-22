public class LibraryInfo {
    private static final LibraryInfo instance = new LibraryInfo();
    public static LibraryInfo getInstance() {
        return instance;
    }
    private LibraryInfo() {}

    private String name;
    private int phone;
    private String address;
    private String openTime;
    private String closeTime;

    // getters
}