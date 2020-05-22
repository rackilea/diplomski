public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.substring(0, Math.min(uuid.length(), 10));
        System.err.println(uuid);
        return uuid;
    }