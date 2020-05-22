public class ClassA {
    private Preferences prefs = Preferences.userRoot().node("TestNode");

    public static void main(String[] args) {
        new ClassA();
    }

    public ClassA() {
        prefs = Preferences.userRoot().node("TestNode/account-1");
        prefs.put("username", "testUser1");
        prefs.removeNode();
        prefs = Preferences.userRoot().node("TestNode");
        try {
            System.out.println(prefs.nodeExists("account-1")); // a test for its existence now outputs 'false'
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }

    }
}