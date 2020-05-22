@Override
public E get(int index)
{
    if(index < 0)
        index = index + size();

    return super.get(index);
}