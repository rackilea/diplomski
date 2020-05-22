/**
     * Creates linked list from array input.
     * 
     * @param input
     *            data array
     * @return linked list with data
     */
    public static LinkedList Of(String[] input) {
        // Checks if array has elements.
        if (input == null || input.length < 1)
            return null;
        // Starts creating the array using overload 2.
        return LinkedList.Of(input, 0);
    }

    /**
     * Creates linked list from array input (overload 2).
     * 
     * @param input
     *            data array
     * @param i
     *            counter to remember at what element is current
     * @return linked list with data
     */
    public static LinkedList Of(String[] input, int i) {
        //Tests if counter is within array elements. 
        if (input.length - 1 > i)
            // Returns new element with (current element data, reference
            // to next element). Note that next element will be returned
            // by this same method (this is why it is recursive).
            return new LinkedList(input[i], LinkedList.Of(input, i + 1));
        //Last element. From here backtracking will begin. 
        return new LinkedList(input[i], null);
    }