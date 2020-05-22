private static final Object LOCK = new Object();
    private static List<UserDto> userCache;
    public static List<UserDto> getUserCache() {
        synchronized (LOCK) {
            if (userCache == null) {
                try {
                    userCache = initUserList();
                } catch (IOException e) {
                    return Collections.emptyList();
                }
            }
            return userCache;
        }
    }