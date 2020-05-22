public static <E> List<E> reverse(List<E> inputList) {
      List<E> ret = new ArrayList<>();
      E o = inputList.remove(0);
      if (inputList.size() > 0) {
         ret = reverse(inputList);
      }
      // at this point they will be on the stack in reverse order.

      // so add them to the stack in that order.
      ret.add(o);
      // return the orginal list to its initial state by inserting them at the beginning.
      inputList.add(0, o);
      return ret;
   }