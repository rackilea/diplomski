public void printBackward(int n) {

    if (n > 0) {
        ListIterator<E> itr = listIterator(); /** Initialisation 1 **/          
        int count = 0; /** Initialisation 2 **/

        E item;
        while (itr.hasNext()) {
            /** Block 1 **/             
            item = itr.next();
            if (++count == n) {
                System.out.println(item); //prints here
                printBackward(n-1);
            }               
        }
        /** Block 2 **/
        // nothing
    } else {            
        /** Block 3 **/
        // nothing
    }
}