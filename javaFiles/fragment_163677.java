import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        int[] sizebefore = { 3, 5, 1, 8 };
        int[] sizeafter = new int[sizebefore.length];
        System.arraycopy(sizebefore, 0, sizeafter, 0, sizebefore.length);

        Arrays.sort(sizeafter);
        System.out.println("your array before sorted: " + Arrays.toString(sizebefore));
        System.out.println("your array after sorted: " + Arrays.toString(sizeafter));

        if (Arrays.equals(sizebefore, sizeafter)) {
            System.out.println("Matches after sort ");
        } else {
            System.out.println("Doesn't match after sort ");
        }
    }

}