public class Blah {

public static void main(String[] args) {
 int[] test = {1, 0, 4, 7, 0, 2, 10, 82, 0};
 System.out.println(Arrays.toString(test) +  ": length = " + test.length);
 int[] result = removeZeros(test);
 System.out.println(Arrays.toString(result) + ": length = " + result.length);
 }

public int[] removeZeros(int[] test) {
    int length = 0;
for (int i=0; i<test.length; i++){
    if (test[i] != 0)
        length++;
}
int [] intResult = new int[length];
for (int i=0, j=0; i<test.length; i++){
    if (test[i] != 0) {
        intResult[j] = test[i];
        j++;
    }
 return intResult;
}

}