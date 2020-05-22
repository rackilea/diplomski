public class NameAndStringList extends ArrayList<Object> implements List<Object>
{
    private boolean stringMode = false;

    @Override
    public boolean add(Object object)
    {
        return super.add(toName(object));
    }

    // Do the same for add(index, element)
    // Do the same for set(index, element)
    // Do the same for remove(object)

    @Override
    public boolean addAll(Collection<? extends Object> collection)
    {
        final List<Name> convertedCollection = new ArrayList<Name>();
        for (Object object : collection)
        {
            convertedCollection.add(toName(object));
        }
        return super.addAll(convertedCollection);
    }

    // Do the same for addAll(index, collection)
    // Do the same for removeAll(index, collection)
    // Do the same for retainAll(index, collection)

    @Override
    public boolean contains(Object o)
    {
        return super.contains(toName(o));
    }

    // Do the same for containsAll(collection)
    // Do the same for indexOf(object)
    // Implement Iterator that checks the stringMode variable before returning value.
    // Override all iterator methods to retrieve custom Iterator implementation.
    // Override subList(fromIndex, toIndex) to make subList be an instance of NameAndStringList as well.

    @Override
    public Object get(int index)
    {
        if (stringMode)
        {
            return ((Name) super.get(index)).getName();
        }
        return super.get(index);
    }

    // Implement setStringMode(boolean)

    protected Object toNameString(Object object)
    {
        if (object instanceof Name)
        {
            // Convert to String here
        }
        return object;
    }

    protected Name toName(Object object)
    {
        if (object instanceof String)
        {
            // Convert to Name here.
        }
        return object;
    }
}