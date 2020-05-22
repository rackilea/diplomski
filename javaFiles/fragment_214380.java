import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Meter {

private List<Double> parameterList = new ArrayList<>();     // Used by the temperature algorithm
private Map<Integer, Double> scaleMap = new HashMap<>(21);  // Used to scale (not necessarily required)

public static void main(String[] args) {
    Meter meter = new Meter();
    meter.initData();

    //30.51 => 01:53:4e:98
    //30.46 => 01:53:8e:94
    //30.43 => 01:53:8e:91
    //30.39 => 01:53:8e:8e
    //30.39 => 01:53:4e:8e

    //12.36 => 01:52:88:b1
    //16.01 => 01:52:c9:cf
    //18.65 => 01:52:ca:a5
    //21.14 => 01:52:8b:74

    // Test each of the provided hex values

    int mapKey = 77;    // 77 seemed the best value; 78 was a bit too high

    String[] values = { "01:53:4e:98", "01:53:8e:94", "01:53:8e:91", "01:53:8e:8e",
            "01:53:4e:8e", "01:52:88:b1", "01:52:c9:cf", "01:52:ca:a5", "01:52:8b:74" };

    ByteBuffer key = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(mapKey);
    ByteBuffer scale = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(0);     // A number around 100175 perhaps provides better results
    ByteBuffer offset = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(0);    // No offset

    for (int i=0; i<values.length; i++) {
        double tempC = meter.calculateTemperature(hexStringToByteArray(values[i]), key.array(), scale.array(), offset.array());
        System.out.printf("%2.3f => %s\n", tempC, values[i]);
    }

}

/**
 * Convert a hex string (which may contain the `:` character) to a byte array
 * @param hexString 4 octets of the form xx:xx:xx:xx
 * @return The byte array
 */
static byte[] hexStringToByteArray(String hexString) {
    hexString = hexString.replaceAll(":", "");
    int len = hexString.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                             + Character.digit(hexString.charAt(i+1), 16));
    }
    return data;
}

/**
 * Populate the algorithm parameters (required), and the scaling factors (not necessarily required)
 */
private void initData() {

    scaleMap.put(65, 29.629);
    scaleMap.put(66, 29.660);
    scaleMap.put(67, 29.691);
    scaleMap.put(68, 29.722);
    scaleMap.put(69, 29.753);
    scaleMap.put(70, 29.784);
    scaleMap.put(71, 29.815);
    scaleMap.put(72, 29.846);
    scaleMap.put(73, 29.877);
    scaleMap.put(74, 29.908);
    scaleMap.put(75, 29.939);
    scaleMap.put(76, 29.970);
    scaleMap.put(77, 30.001);
    scaleMap.put(78, 30.032);
    scaleMap.put(79, 30.063);
    scaleMap.put(80, 30.094);
    scaleMap.put(81, 30.125);
    scaleMap.put(82, 30.156);
    scaleMap.put(83, 30.187);
    scaleMap.put(84, 30.218);
    scaleMap.put(85, 30.249);

    parameterList.add(52.94);
    parameterList.add(49.61);
    parameterList.add(46.51);
    parameterList.add(43.62);
    parameterList.add(40.94);
    parameterList.add(38.44);
    parameterList.add(36.12);
    parameterList.add(33.95);
    parameterList.add(31.93);
    parameterList.add(30.05);
    parameterList.add(28.29);
    parameterList.add(26.61);
    parameterList.add(25.05);
    parameterList.add(23.59);
    parameterList.add(22.23);
    parameterList.add(20.96);
    parameterList.add(19.76);
    parameterList.add(18.65);
    parameterList.add(17.60);
    parameterList.add(16.63);
    parameterList.add(15.71);
    parameterList.add(14.84);
    parameterList.add(14.02);
    parameterList.add(13.25);
    parameterList.add(12.53);
    parameterList.add(11.86);
    parameterList.add(11.22);
    parameterList.add(10.63);
    parameterList.add(10.07);
    parameterList.add(9.541);
    parameterList.add(9.046);
    parameterList.add(8.572);
    parameterList.add(8.126);
    parameterList.add(7.706);
    parameterList.add(7.311);
    parameterList.add(6.938);
    parameterList.add(6.588);
    parameterList.add(6.257);
    parameterList.add(5.946);
    parameterList.add(5.651);
    parameterList.add(5.374);
    parameterList.add(5.109);
    parameterList.add(4.859);
    parameterList.add(4.623);
    parameterList.add(4.400);
    parameterList.add(4.189);
    parameterList.add(3.990);
    parameterList.add(3.801);
    parameterList.add(3.623);
    parameterList.add(3.454);
    parameterList.add(3.294);
    parameterList.add(3.141);
    parameterList.add(2.996);
    parameterList.add(2.858);
    parameterList.add(2.728);
    parameterList.add(2.604);
    parameterList.add(2.487);
    parameterList.add(2.376);
    parameterList.add(2.270);
    parameterList.add(2.170);
    parameterList.add(2.075);
    parameterList.add(1.984);
    parameterList.add(1.897);
    parameterList.add(1.815);
    parameterList.add(1.737);
    parameterList.add(1.662);
    parameterList.add(1.591);
    parameterList.add(1.524);
    parameterList.add(1.459);
    parameterList.add(1.398);
    parameterList.add(1.340);
    parameterList.add(1.284);
    parameterList.add(1.231);
    parameterList.add(1.180);
    parameterList.add(1.132);
    parameterList.add(1.086);
    parameterList.add(1.042);
    parameterList.add(1.000);
    parameterList.add(0.9599);
    parameterList.add(0.9216);
    parameterList.add(0.8851);
    parameterList.add(0.8501);
    parameterList.add(0.8168);
    parameterList.add(0.7849);
    parameterList.add(0.7545);
    parameterList.add(0.7254);
    parameterList.add(0.6974);
    parameterList.add(0.6707);
    parameterList.add(0.6451);
    parameterList.add(0.6207);
    parameterList.add(0.5973);
    parameterList.add(0.5743);
    parameterList.add(0.5523);
    parameterList.add(0.5313);
    parameterList.add(0.5112);
    parameterList.add(0.4920);
    parameterList.add(0.4736);
    parameterList.add(0.4560);
    parameterList.add(0.4392);
    parameterList.add(0.4230);
    parameterList.add(0.4076);
    parameterList.add(0.3925);
    parameterList.add(0.3781);
    parameterList.add(0.3642);
    parameterList.add(0.3510);
    parameterList.add(0.3383);
    parameterList.add(0.3261);
    parameterList.add(0.3144);
    parameterList.add(0.3032);
    parameterList.add(0.2925);
    parameterList.add(0.2822);
    parameterList.add(0.2722);
    parameterList.add(0.2626);
    parameterList.add(0.2534);
    parameterList.add(0.2445);
    parameterList.add(0.2360);
    parameterList.add(0.2279);
    parameterList.add(0.2201);
    parameterList.add(0.2126);
    parameterList.add(0.2054);
    parameterList.add(0.1984);
    parameterList.add(0.1917);
    parameterList.add(0.1852);
    parameterList.add(0.1790);
    parameterList.add(0.1731);
    parameterList.add(0.1673);
    parameterList.add(0.1618);
    parameterList.add(0.1564);
    parameterList.add(0.1513);
    parameterList.add(0.1464);
    parameterList.add(0.1416);
    parameterList.add(0.1370);
    parameterList.add(0.1326);
    parameterList.add(0.1283);
    parameterList.add(0.1242);
    parameterList.add(0.1203);
    parameterList.add(0.1164);
    parameterList.add(0.1128);
    parameterList.add(0.1092);
    parameterList.add(0.1058);
    parameterList.add(0.1026);

}

/**
 * 
 * @param b1array The hex number b1:b2:b3:b4 (as a byte array)
 *            - The only bits used are b2 (6 low bits & x3f) and b3
 *            (all 8 bits & xff)
 * @param mapKey
 *            - Value from 65 to 85; if 77 then scale is 1.0; otherwise < 77
 *            or > 77 causes scaling
 * @param byte1Scale
 *            - Equal to zero (scale=1), or units in micro (10E6) where
 *            scale=value/10E6
 * @param byte1Offset
 *            - Measured in 10E6 (micro) - offset amount
 * @return The temperature in degrees Celsius
 */
public double calculateTemperature(byte[] b1array, byte[] mapKey, byte[] byte1Scale, byte[] byte1Offset) {

    double scale;
    int scaleMicroValue = ByteBuffer.wrap(byte1Scale).order(ByteOrder.LITTLE_ENDIAN).getInt();
    if (scaleMicroValue == 0) {
        scale = 1.0D;
    } else {
        scale = scaleMicroValue / 1000000.0D;
    }

    double offsetValue = ByteBuffer.wrap(byte1Offset).order(ByteOrder.LITTLE_ENDIAN).getInt() / 1000000.0D;

    /* 14 bits: b2_5 b2_4 ... b2_0 b3_7 .. b3_0 */
    byte byte2 = b1array[2];
    byte byte3 = b1array[3];
    int bitValue = (byte3 & 0xFF | (byte2 & 0x3F) << 8);
    double scaledBitValue = bitValue * scale - offsetValue;

    int key = (byte) (mapKey[0] & 0xFF);
    double mapValue = scaleMap.containsKey(key) ? scaleMap.get(key) : scaleMap.get(77);

    double param1 = 0.0;
    double param2 = parameterList.get(0);
    double result = 33.0D / scaledBitValue * (8191.0D - scaledBitValue) / mapValue;

    int i = 0;
    int j = parameterList.size();
    double minParameter = parameterList.get(j - 1);

    if (param2 < result || minParameter > result)
        return 0;

    int index = 0;
    boolean process = true;
    while (i < j && process) {
        if (result >= parameterList.get(i)) {
            if (i == 0) {
                param1 = parameterList.get(i);
                param2 = parameterList.get(i + 1);
                index = i;
                process = false;
            }
            if (process) {
                param1 = parameterList.get(i - 1);
                param2 = parameterList.get(i);
                index = i - 1;
            }
            process = false;
        }
        if (process)
            i++;
    }
    if (process) {
        index = 0;
        param2 = 0;
    }

    double voltage = 0.0;   // I don't even know if this is voltage (but it is only calculated if temp between 33.2 and 36
    double tempC = index + (result - param1) / (param2 - param1) - 40.0D;

    if ((tempC < 34.0D) && (tempC >= 33.2D)) {
        voltage = 1.95D;
    }

    while (true) {
        if ((tempC < 34.1D) && (tempC >= 34.0D)) {
            voltage = 1.881D;
        } else if ((tempC < 34.2D) && (tempC >= 34.1D)) {
            voltage = 1.805D;
        } else if ((tempC < 34.3D) && (tempC >= 34.2D)) {
            voltage = 1.71D;
        } else if ((tempC < 34.4D) && (tempC >= 34.3D)) {
            voltage = 1.615D;
        } else if ((tempC < 34.5D) && (tempC >= 34.4D)) {
            voltage = 1.52D;
        } else if ((tempC < 34.6D) && (tempC >= 34.5D)) {
            voltage = 1.4249999999999998D;
        } else if ((tempC < 34.7D) && (tempC >= 34.6D)) {
            voltage = 1.3299999999999998D;
        } else if ((tempC < 34.8D) && (tempC >= 34.7D)) {
            voltage = 1.2349999999999999D;
        } else if ((tempC < 34.9D) && (tempC >= 34.8D)) {
            voltage = 1.14D;
        } else if ((tempC < 35.0D) && (tempC >= 34.9D)) {
            voltage = 1.045D;
        } else if ((tempC < 35.1D) && (tempC >= 35.0D)) {
            voltage = 0.95D;
        } else if ((tempC < 35.2D) && (tempC >= 35.1D)) {
            voltage = 0.855D;
        } else if ((tempC < 35.3D) && (tempC >= 35.2D)) {
            voltage = 0.76D;
        } else if ((tempC < 35.4D) && (tempC >= 35.3D)) {
            voltage = 0.6649999999999999D;
        } else if ((tempC < 35.5D) && (tempC >= 35.4D)) {
            voltage = 0.57D;
        } else if ((tempC < 35.6D) && (tempC >= 35.5D)) {
            voltage = 0.475D;
        } else if ((tempC < 35.7D) && (tempC >= 35.6D)) {
            voltage = 0.38D;
        } else if ((tempC < 35.8D) && (tempC >= 35.7D)) {
            voltage = 0.285D;
        } else if ((tempC < 35.9D) && (tempC >= 35.8D)) {
            voltage = 0.19D;
        } else {
            if (tempC >= 36.0D) {
                break;
            }
            if (tempC < 35.9D) {
                break;
            }
            voltage = 0.095D;
        }
    }
    return tempC;
}

/**
 * I don't know what this function is:  It always calculates around 4.16 - 4.18
 * @param bArray The hex number b1:b2:b3:b4 (as a byte array)
 * Uses: 
 * byte0:  Low 2 bits
 * byte1:  all bits
 * byte2:  high 2 bits
 * @return I don't know the significance of this value
 */
public double m(byte[] bArray) {
    int byte2 = bArray[2];
    int byte1 = bArray[1];
    int byte0 = bArray[0];
    return 0.003077674645823156D * (((byte0 & 0x3) << 2 | (byte1 & 0xC0) >> 6) << 8
            | (byte2 & 0xC0) >> 6 | (byte1 & 0x3F) << 2);
}
}