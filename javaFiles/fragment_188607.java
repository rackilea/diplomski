public static <E> E fold(Func<E,Func<E,E>> f, E acc, LinkedList<E> lst) {
    if (lst.isEmpty()) {
        return acc;
    } else {
        LinkedList<E> listClone = (LinkedList<E>) lst.clone();
        E theHead = listClone.removeFirst();
        //             A  B <- remember the Func interface? here A is E and B is Func<E,E>
        // f is a Func<E, Func<E, E>> that takes in an E and returns
        // another Func<E, E> after calling apply thus
        // breaking the steps:
        // f.apply(E) <- we just called the apply method thus this should return a "B"
        // Since B is a Func<E, E> we need to call apply to perform the operation
        // onto the next element, which in this case is an addition. You can think
        // of it as a -> b -> a + b. 
        // Now you played that nice trick of using recursion to call this function
        // and traverse all elements till the end of the collection and accumulate
        // all the intermediate results.
        return (E) f.apply(theHead).apply((fold(f,acc,listClone)));
        // the listClone is one element shorter in each recursion
        // since you are removing the first element
    }
}