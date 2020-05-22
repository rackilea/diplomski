HashSet<int> values = new HashSet<int>(array);
foreach (int value in array)
{
    if (values.Contains(value + no))
    {
        // Found a match
    }
}