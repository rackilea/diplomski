Parent func(Class<? extends Parent> child, String whichChild) throws Exception {
    // whichChild: "ChildA" or "ChildB"

    Parent obj = child.newInstance();
    //...
}