int[] same
for (int i = arr1.length; i >= 0; i--)
{
    if(arr2.contains(i))
        same.add(i)
        arr1.remove(i)
}
for (int i = arr2.length; i >= 0; i--)
{
    if(same.contains(i))
        arr2.remove(i)
}