public static void throwsOrNotThrowsThatsTheQuestion() {
try {

    // Any processing
    throw new RuntimeException("Fake!");

} catch (Exception e) {
    throw e;
}