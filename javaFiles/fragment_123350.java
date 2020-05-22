public static double parseTemperatureBytes(byte[] temperatureBytes) {
    int firstByte = temperatureBytes[0] & 0x7F;
    int secondByte = temperatureBytes[1] & 0xFF;
    double temperature = ((firstByte << 8) | secondByte) / 10.0;

    if (getMostSignificantBit(temperatureBytes[0]) > 0) {
        temperature = -temperature;
    }

    return temperature;
}