import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class TestSO09_39463168_StringToMinimalNumber {

    public static void main(String[] args) {
        List<String> strNumbers = Arrays.asList("0", //int
                "123", //int
                "-456", //int
                "2147483700", // Long
                "-2147483700", // Long
                "9223372036854775900", //BigInt
                "-9223372036854775900" //BigInt
                );

        for(String strNumber : strNumbers){
            Number number = stringToMinimalNumber(strNumber);
            System.out.println("The string '"+strNumber+"' is a "+number.getClass());
        }

    }

    public static Number stringToMinimalNumber(String s){
        BigInteger tempNumber = new BigInteger(s);

        if(tempNumber.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0 || tempNumber.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0){
            return tempNumber;
        } else if(tempNumber.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 || tempNumber.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0){
            return tempNumber.longValue(); //Autobox to Long
        } else {
            return tempNumber.intValue(); //Autobox to Integer
        }

    }

}