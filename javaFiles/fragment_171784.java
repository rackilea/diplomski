public static void main (String[] args) throws java.lang.Exception
    {

    int[] list = {1, 2, 3, 4, 5};
    list=reverse(list);

    for (int i = 0; i < list.length; i++)
    {
        System.out.print(list[i] + " ");
    }
    }

public static int[] reverse(int[] list)
{
    int[] temp = new int[list.length];

    for (int i = 0; i < list.length; i++)
    {
        temp[i] = list[(list.length - 1) - i];
        //list[i]=temp[i];

    }

    list = temp;
    return list;
}