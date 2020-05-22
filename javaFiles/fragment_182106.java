public class MyClass {
    public static void main(String args[]) {
        System.out.println(substrInMultiple("abcd", "cdabcdab"));
    }

    public static int substrInMultiple(String A, String B) {
        String multiple = A;
        int multipleCount = 1;
        while(!multiple.contains(B)) {
            multiple += A;
            multipleCount++;
        }
        return multipleCount;
    }
}