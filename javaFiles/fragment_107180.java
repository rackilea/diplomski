public class StatefulClass{

    //This fields make the object STATEFUL
    private int totalSum = 0;

    public int sum(int a, int b){
        int sum = a + b;
        totalSum = totalSum + sum;
        if (totalSum > 100)
            System.out.println("This thread "+Thread.currentThread().getId()+
                +" got it!");
        return sum;
    }

}