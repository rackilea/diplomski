for (int i = 0; i < 12; i++)
{
    int value;
    do {
        value = sc.nextInt();
    } while (value < 0 || value > 100);
    nums[i] = value;
}