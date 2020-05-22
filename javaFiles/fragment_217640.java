public class MyArrayList<T>
{
    private T[] asArray;

    @SuppressWarnings("unchecked")
    public MyArrayList()
    {
        asArray = (T[]) new Object[0];
    }

    public void add(T t)
    {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[asArray.length + 1];

        // copy everything over to the new array
        for (int i = 0; i < asArray.length; i++)
        {
            temp[i] = asArray[i];
        }

        // add the new element
        temp[asArray.length] = t;
        asArray = temp;
    }

    public void remove(int index)
    {
        if (index < 0 || index >= asArray.length) return;
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[asArray.length - 1];

        boolean found = false;
        // copy everything over to the new element
        for (int i = 0; i < asArray.length; i++)
        {
            // don't copy if the indices are the same
            if (i == index)
            {
                found = true;
                continue;
            }
            temp[i - (found ? 1 : 0)] = asArray[i]; // it's i - 1 after the removed object so then it doesn't leave a gap and it doesn't go over the array's length
        }
        asArray = temp;
    }

    public T get(int index)
    {
        return asArray[index];
    }
}