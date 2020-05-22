public static double movingAverage(
    LinkedList<AverageObject> valueList) {
    synchronized (valueList) {
       ...
    }
}