for (x = 0; x < array[y].length; x++)
{
    if (array[y][x] <= lowest) {
        lowest = array[y][x];
        indexOfLowest = x;
    }
}