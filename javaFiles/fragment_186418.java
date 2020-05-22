public class MyException extends Exception {

    private List<Cause> causes;

    public MyException(Cause... cs) {
        causes = new ArrayList<Cause>(Arrays.asList(cs));
    }
}