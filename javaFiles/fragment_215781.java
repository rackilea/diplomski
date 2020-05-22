public interface IAstNode<T extends IAstNode<T>> extends ICopy<T> {

    ImmutableList<T> getChildren() ;

    int getStartLine() ;
    int getEndLine() ;

    T copy();
}