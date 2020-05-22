public static String getStackAsString() {
    switch (stack) {
    case DOOR:
        return "Door";
    case TREASURE:
        return "Treasure";
    default:
        return "Unknown Stack";
    }
}