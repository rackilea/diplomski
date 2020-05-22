import java.util.Arrays;

public class HexToDec {

    public static String convertHexToSigned8Bit(String hex) {
        return Arrays
                .stream(hex.split(" +"))
                .map(s -> "" + (byte) Integer.parseInt(s, 16))
                .reduce((s, s2) -> s + " " + s2)
                .get();
    }


    public static void main(String[] args) {
        String hexidecimal = "50  4b e0  e7";
        String signed8Bit = convertHexToSigned8Bit(hexidecimal);
        System.out.print(signed8Bit);
    }

}