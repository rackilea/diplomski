/**
 * Method is parameterized in the list-type, thus achieving maximal type checking. If the
 * inner lists are of different types, the inner lists must be of type List<Object>,
 * other types will not work. Type-checking is out of the window at that point.
 *
 * @param lists the list of lists, non-null and not containing null's.
 * @param i     the index to pick in each list, must be >= 0.
 * @param <T>   generic parameter of inner lists, see above.
 * @return      a List<T>, containing the picked elements.
 */
public static <T> List<T> getIthOfEach(List<List<T>> lists, int i) {
    List<T> result = new ArrayList<T>();

    for(List<T> list : lists) {
        try {
            result.add(list.get(i)); // get ith element, add it to the result-list
        // if some list does not have an ith element, an IndexOutOfBoundException is 
        // thrown. Catch it and continue.
        } catch (IndexOutOfBoundsException e) { } 
    }
    return (result);
}