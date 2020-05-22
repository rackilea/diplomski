static NavigableMap<Double, String> decimalFormatMap = new TreeMap<Double, String>();
static
{
    decimalFormatMap.put(0.00001, "0.000001");
    decimalFormatMap.put(0.0001, "0.00001");
    decimalFormatMap.put(0.001, "0.0001");
    decimalFormatMap.put(0.01, "0.001");
    decimalFormatMap.put(0.1, "0.01");
    decimalFormatMap.put(1.0, "0.1");
    decimalFormatMap.put(100.0, "1");
}
NumberTickUnit numberTickUnit = * some key number *;
String decimalFormat = decimalFormatMap.get(
    decimalFormatMap.floorKey(numberTickUnit.getSize()));