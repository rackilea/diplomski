static void bubbleSort(List<WebElement> items)
{
    int n = items.size();
    boolean swapped;
    for (int i = 0; i < n - 1; i++)
    {
        swapped = false;
        for (int j = 0; j < n - i - 1; j++)
        {
            int compare = items.get(j).getText().compareTo(items.get(j + 1).getText());
            if (compare < 0)
            {
                swap(items.get(j + 1), items.get(j));
                swapped = true;
            }
        }

        // break if no elements were swapped
        if (swapped == false)
        {
            break;
        }
    }
}