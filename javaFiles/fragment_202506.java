public void incrementCount(int count){
    int increment = (count * 2);
    Object newElementData [] = new Object[increment];
    for(int i = 0; i < count; i++)
    {
        newElementData[i] = elementData[i];
    }

    elementData = new Object[increment];

    elementData = newElementData;
}