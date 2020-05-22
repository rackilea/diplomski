{
    Tree<Object> x = new Tree<Object>();
    MyTree<Integer> y = new MyTree<Integer>();
    Tree<Integer> z = new Tree<Integer>();

    x.add(y);
    y.add(x); // not valid, as Tree<Object> does not extend Tree<Integer>  
    y.add(z); // fine, as Tree<Integer> matches
}

public static class MyTree<T> extends Tree<T> {     
}