public class BinaryToDecimal{
public static void main(String[]args){
    int binary = 101011101;
    int powerOfTen = 10;
    int powerOfTwo = 1;
    int Decimal = 0;
    for (int j=1;j<=8;j++){
        int splitAnswer = (binary/powerOfTen%10)*powerOfTwo;
        int old = splitAnswer;
        Decimal = splitAnswer + old;
        powerOfTen*=10;
        powerOfTwo*=2;
    }
    System.out.println("The binary number " + binary + " is equivalent to "+ Decimal +" in decimal.");
}