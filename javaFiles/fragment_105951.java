/* For autonumbering anonymous threads. */
private static int threadInitNumber;

private static synchronized int nextThreadNum() {
    return threadInitNumber++;
}