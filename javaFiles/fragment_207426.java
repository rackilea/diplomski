for (int i = 0; i<52; i++) 
{
    index = i + random.nextInt(52 - i);

    if (index != i)
    {
        Card temp = data[i];

        data[i] = data[index];

        data[index] = temp;
    }
}