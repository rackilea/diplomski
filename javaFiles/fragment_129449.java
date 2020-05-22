public static void main(String[] args)
{
    int[] temp_array = {1};
    method(temp_array);
    System.out.println(temp_array[0]);
}
public static void method(int[] n)
{
    int[] temp = new int[]{2};
    System.arraycopy(temp, 0, n, 0, n.length); 
    // or System.arraycopy(temp, 0, n, 0, temp.length) - 
    // since we assumed that n and temp are of the same length
}