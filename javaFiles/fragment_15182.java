/**
@param P parent
@param C child
@param S self
*/
interface Element<P extends Element<?, S, P>, 
        C extends Element<S, ?, C> ,
        S extends Element<P, C, S>> {
    public P getParent();
    public Collection<C> getChildren();
}