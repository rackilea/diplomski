import java.util.ArrayList;
import java.util.List;


public class Test009 {

    public static void main(String[] args) {
        List<Agent> resultList = new ArrayList<Agent>();
        resultList.add(null);
        resultList.add(new Agent1());
        resultList.add(new Agent());
        messUp(resultList);
        test(resultList);
    }

    private static void messUp(List lst){
        lst.add("123");
    }

    public static void test(List<Agent> resultList){
        Agent[] array = new Agent[resultList.size()];
        resultList.toArray(array);
        System.out.println("done");     
    }
}

class Agent {
    protected int x;
}

class Agent1 extends Agent{
    protected int y;
}