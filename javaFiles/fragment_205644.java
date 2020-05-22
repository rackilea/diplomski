public static void main(String[] args)
{
    int[] arr = new int[100], newArr = new int[100];
    int j=0;
    Random random = new Random();

    for (int i = 0; i < arr.length; i++)
    {
        int randNum = random.nextInt(600) - 350;
        arr[i] = randNum;
    }

    for (int i = 0; i < arr.length; i++)
    {
        if (arr[i] > 0){
            newArr[j]=arr[i];
            j++;
        }
    }

    // and add code for numbers=0 and less than 0. So you should append code:
    for (int i = 0; i < arr.length; i++)
    {
        if (arr[i] == 0){
            newArr[j]=arr[i];
            j++;
        }
    }

    for (int i = 0; i < arr.length; i++)
    {
        if (arr[i] < 0){
            newArr[j]=arr[i];
            j++;
        }
    }

    System.out.println(Arrays.toString(newArr));
}