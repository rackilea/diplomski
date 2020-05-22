ArrayList<Integer> numbers = new ArrayList<Integer>();
int size = myList.getAdapter().getCount();
    for(int i = 0; i < size; i++)
    {
        numbers.add((Integer) myList.getAdapter().getItem(i));
    }