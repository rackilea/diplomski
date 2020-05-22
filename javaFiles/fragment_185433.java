//        Add S to be T's type parameter         Add <S> to SuperBean here
class AbstractService<S extends SuperBean, T extends SuperBean<S>> {
    // I'm assuming superBean is defined here.
    T superBean;

    //this is what I'm aiming for
    void add(S item) {
        superBean.getSublist().add(item);
    }
}