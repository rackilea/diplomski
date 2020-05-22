import java.util.Arrays;

public class HexToDec {

    public static String convertHexToSigned8Bit(String hex) {
        String[] tokens = hex.split(" +");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tokens.length - 1; i++) { //append all except last
            result.append((byte) Integer.parseInt(tokens[i], 16)).append(" ");
        }
        if (tokens.length > 1) //if more than 1 item in array, add last one
            result.append((byte) Integer.parseInt(tokens[tokens.length - 1], 16));
        return result.toString();
    }


    public static void main(String[] args) {
        String hexidecimal = "50  4b e0  e7";
        String signed8Bit = convertHexToSigned8Bit(hexidecimal);
        System.out.print(signed8Bit);
    }

}