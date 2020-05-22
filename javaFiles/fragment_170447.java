for (int i = 0; i < total; i++)
{
    /* Move It Here */
    String[] subSets = new String[maxLength];
    for (int j = 0; j < maxLength; j++)
    {
        subSets[j] = inputs[index[j]];
    }
    allList.add(subSets);
    if (i != (total - 1))
        index = nextIndex (index, maxLength, inputs.length);
}