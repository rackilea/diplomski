public class Test {
    public static void main(String[] args) {
        int[] oldList = {1, 2, 3, 4, 5};
        oldList = reverse(oldList); //assign the returned value from the method
        for (int i = 0; i < oldList.length; i++)
            System.out.print(oldList[i] + " ");
    }
    public static int[] reverse(int[] list) {
        int[] newList = new int[list.length];
        for (int i = 0; i < list.length; i++)
            newList[newList.length] = list[list.length - 1 - i];
        list = newList;
        return list;
    }
}