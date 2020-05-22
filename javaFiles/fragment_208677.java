public static void throwsOrNotThrowsThatsTheQuestion() {
try {

    // Any processing
    throw new IOException("Fake!");

} catch (Exception e) {
    throw e;
}