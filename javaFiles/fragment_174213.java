int minDiff = Math.abs(targetWidth - width_of_item_0);
int minDiff_index = 0;
for (int i = 1; i < itemCount; i++)
{
    int diff = Math.abs(targetWidth - width_of_item_i)
    if (diff < minDiff)
    {
       minDiff = diff
       minDiff_index = i
    }
}

// minDiff_index now points at the closest item to targetWidth