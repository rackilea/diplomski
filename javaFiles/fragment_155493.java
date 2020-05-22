if (low < high)
        {
            i = partition(low, high);
            sort(i + 1, high);
            sort(low, i - 1);
        }