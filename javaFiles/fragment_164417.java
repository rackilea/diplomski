void printIndented(int size, String word, boolean n)
{
    print(StringUtils.repeat(" ", size));

    print(word);
    if(n)
       println("");    
}