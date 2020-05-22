public void bubbleSort
{
  for (int i = 0; i < size; i++)
  {
    for (int j = i; j < size; j++)
    {
       if (elementAt(j).compareTo(elementAt(j+1)) > 0)
       {
          swap(j, j + 1);
       }
    }
  }
}

public SinglyNode elementAt(int index)
{
   SinglyNode temp = first;

   for (int i = 0, i < index; i++)
   {
      temp = temp.getNext();
   }

   return temp;
}

public void swap(int firstIndex, int secondIndex)
{
   SinglyNode secondNext = elementAt(secondIndex).getNext();       
   SinglyNode second = elementAt(secondIndex);
   SinglyNode first = elementAt(first);
   SinglyNode firstPrevious = elementAt(first - 1);


   firstPrevious.setNext(second);
   first.setNext(secondNext);
   second.setNext(first);
}