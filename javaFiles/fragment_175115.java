import java.util.List;
import java.util.ArrayList;

public class Main{
    static interface Testing{

        <S> List<S> getAList();
        <S> List<S> broken(List<String> check);
    }

    static class Junk implements Testing{
        public List<Number> getAList(){
            return new ArrayList<>();
        }
        public List<Number> broken(List<String>check){
            return new ArrayList<>();
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
    }
}