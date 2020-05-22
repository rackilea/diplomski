public class MyException extends Exception {

    private List<Cause> causes;

    public MyException(Cause... causes) {
        this.causes = new ArrayList<Cause>(Arrays.asList(causes));
    }
}