public ClassName() {

    public void timeMethod() {

        long startOfmethod = System.currentTimeMillis(); // ***

        methodToTime();

        long endOfMethod = System.currentTimeMillis();   // ***

        long totalTime = endOfMethod = -startOfmethod;

        LOGGER.info("[Method Took: {}", DurationFormatUtils.formatDuration(totalTime, "H:mm:ss", true) + "]\n");
    }
}