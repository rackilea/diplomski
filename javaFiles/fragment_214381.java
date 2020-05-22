/**
 * Arg[0] is expected to be the input (a hex string)
 * The output is the temperature (printed to the console)
 * @param args One value; The hex string
 */
public static void main(String[] args) {

    Meter meter = new Meter();
    meter.initData();
    int mapKey = 77;    // Scaling factor
    ByteBuffer key = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(mapKey);
    ByteBuffer scale = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(1000180);       // No scaling
    ByteBuffer offset = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(0);    // No offset

    byte[] hexString = hexStringToByteArray(args[0]);

    double tempC = meter.calculateTemperature(hexString, key.array(), scale.array(), offset.array());
    System.out.printf("%.2f", tempC);

}