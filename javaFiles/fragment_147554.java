class AccountManager {
    private static Map<String, String> accounts = new HashMap<>();

    static void createAccount(String username, String authpassword) {
        accounts.put(username, authpassword);
    }

    static String getAuthPassword(String username) {
        return accounts.get(username);
    }

    public static void main(String[] args) {
        // get the input from somewhere
        AccountManager.createAccount(username, authpassword);
        AccountManager.getAuthPassword(username);
    }
}