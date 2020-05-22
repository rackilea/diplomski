int max = -1;
int index = -1;

for (int i = 0; i < array.Length; i++)
{
    int value = Integer.parse(array[i]);
    if (value > max)
    {
        max = value;
        index = i;
    }
}