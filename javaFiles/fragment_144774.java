public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface CanMove{
        Double speed();
    }

    interface CanFly extends CanMove{
       public Double speed(CanFly target);  
    }
}