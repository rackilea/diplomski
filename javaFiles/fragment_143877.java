public int findMaxReadingIndex1(int startIndex, int endIndex) {
    int maxValue = (int) sensorReadings.get(startIndex).getValue();
    int maxIndex = startIndex;
    int i = 0;

    for (SensorReading sensorReading : sensorReadings) {
        if (i >= startIndex && i<= endIndex && sensorReading.getValue() > maxValue) {
            maxValue = (int) sensorReading.getValue();
            maxIndex = i;
        }

        i++;
    }

    return maxIndex;
}