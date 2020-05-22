public interface JSStatementVisitor<V, E extends Exception> {

    public V visitBlock(JSBlock value) throws E;

    public V visitVariable(JSVariableStatement value) throws E;

    public V visitEmpty(JSEmptyStatement value) throws E;

    ...

}