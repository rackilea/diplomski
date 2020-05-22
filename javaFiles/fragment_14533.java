public abstract class Checkable<X extends Exception> {

    protected abstract X getException(int stuff);

    protected void doCheck(int stuff) throws CommonException, X {
        if (stuff == 1) {
            throw this.getException(stuff);
        }
        throw new CommonException(stuff);
    }

}