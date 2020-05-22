private E sortRemove()
{
    E value = elementData[0];
    elementData[0] = elementData[size-1];
    size--;
    bubbleDown(0);
    return value;
}