public interface UDSession<T> {

    public void authenticate(String user) throws UDException;

    public void linkAccount(T authInfo) throws UDException;

}