public void removeElements(List list, int current) {
   int removeIndex = current + 2;     // remove the third element
   if (removeIndex >= list.size())    // if there isn't one, stop
      return;

   list.remove(removeIndex);          // if there is one, remove it
   removeElements(list, removeIndex); // continue with the rest of the list
}