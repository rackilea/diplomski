for(int i = 0; i < input.length() - 1; i++)
{
    if(array[i] == array[i+1])
    {
        System.out.println(i);
        do {
            i++;
        } while (i < input.length() - 1 && array[i] == array[i + 1]);
    }
}