import java.util.Arrays;
import java.util.Scanner;

    public class JavaApplication1 {

    public static void main(String[] args) {
    int[] a = new int[args.length];
    Scanner scan=new Scanner(System.in);
    a = args.clone(); /*Does what you need by cloning the arguments array. Also takes up exactly as much room is needed to do so (I.e. Not always 10 spaces for values). */