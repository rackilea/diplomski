public E remove(int index) {
    RangeCheck(index);

    modCount++;
    E oldValue = (E) elementData[index];

    int numMoved = size - index - 1;
    if (numMoved > 0)
         System.arraycopy(elementData, index+1, elementData, index,
             numMoved);
    elementData[--size] = null; // Let gc do its work

    return oldValue;
}