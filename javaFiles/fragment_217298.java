@Service
// as MyException is not a RunTimeException it must be declared
public class Validate throws MyException {

    public void giveAName(String name){
    if (name==null) {
        throw new MyException("Name is null"); // not caught locally ...
    }
}