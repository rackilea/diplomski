void shuffleFields (Field[] fields)
{
    Random r = new Random();
    for (int i = fields.length - 1; i >= 1; --i)
    {
        int j = r.nextInt(i + 1);
        Field t = fields[i];
        fields[i] = fields[j];
        fields[j] = temp;
    }
}