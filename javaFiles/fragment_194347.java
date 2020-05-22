public void removeElements(List list, int current, int n) {
   int removeIndex = current + n - 1;    // remove the nth element
   if (removeIndex >= list.size())       // if there isn't one, stop
      return;

   list.remove(removeIndex);             // if there is one, remove it
   removeElements(list, removeIndex, n); // continue with the rest of the list
}

public void removeEverySecond(List list) {
   removeElements(list, 0, 2);
}

public void removeEveryThird(List list) {
   removeElements(list, 0, 3);
}

// etc.