interface Visitor<T> {

    Visitor<T> visitTree(Tree<T> tree);

    void visitData(Tree<T> parent, T data);
}

interface Visitable<T> {

    void accept(Visitor<T> visitor);
}