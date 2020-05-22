while( iterator.hasNext() ) { // the first time will return true, so the next line will be executed.

      Object o = iterator.next(); // give me that item. ( 1st element ) 

      Object b = iterator.next(); // oops dangerous by may work ... ( 2nd element ) 

      Object c = iterator.next(); // eeeerhhh... disaster: NoSuchElementException is thrown.

}