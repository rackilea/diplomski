public boolean isPalindrome(int[] array, int start, int end)
{
    if(array.length == 0 || array.length == 1)
        return true;

    if(start >= end)
        return true;

    if(array[start] != array[end])
        return false;

    return isPalindrome(array, start + 1, end -1);
}