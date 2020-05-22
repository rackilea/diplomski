int getGreatestDigit(int num)
{
    if (num == 0) return 0;
    int lastNum = num % 10;
    int otherDigits = num / 10;
    int recursiveLastNum = getGreatestDigit(otherDigits);
    return Math.Max(lastNum, recursiveLastNum);
}