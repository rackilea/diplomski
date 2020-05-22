public class SizeLimitedArray<E> implements java.util.List<E>
    {
    private static final int DEFAULT_SIZE_LIMIT = 10;
    private ArrayList<E> myList;
    private int maxSize;

    public SizeLimitedArray ()
        {
        this (DEFAULT_SIZE_LIMIT);
        }

    public SizeLimitedArray (int size)
        {
        myList = new ArrayList<E> (size);
        maxSize = size;
        }

    @Override
    public boolean add (E objectToAdd)
        {
        if (myList.size () > maxSize)
            {
            throw new IllegalStateException ("The array is full");
            }

        return myList.add (objectToAdd);
        }

    @Override
    public boolean addAll (Collection collectionToAdd)
        {
        if (myList.size () + collectionToAdd.size () > maxSize)
            {
            throw new IllegalStateException ("The array is full");
            }

        return myList.addAll (collectionToAdd);
        }

    // Rest of class omitted for brevity
    }