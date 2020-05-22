public class HomeWork {
    public static void main(String[] args) {

        int[] arr=new int[] {100, 37, 49};

        Condition[] conditions= new Condition[]{
                                                new Negative(), 
                                                new Prime(), 
                                                new PerfectSquare()
                                            };

        for (Condition condition : conditions) {
            System.out.println(condition.makeYourCondition(arr));
        }
    }
}

interface Condition {
    boolean makeYourCondition(int[] input);
}

class Negative implements Condition {

    @Override
    public boolean makeYourCondition(int[] input) {

        for (int i : input) {
            if(i<0) return true;
        }

        return false;
    }

}

class Prime implements Condition {

    @Override
    public boolean makeYourCondition(int[] input) {

        //TODO PUT YOUR CONDITION

        return false;
    }

}

class PerfectSquare implements Condition {

    @Override
    public boolean makeYourCondition(int[] input) {

        //TODO PUT YOUR CONDITION

        return false;
    }

}