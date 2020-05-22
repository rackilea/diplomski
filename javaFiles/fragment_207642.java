import java.util.ArrayList;

public class PerfectNumbers {

    public static void main(String[] args) {
        long num = 1000;
        int sum = 0;
        ArrayList<Integer> perfectList = new ArrayList<>();
        ArrayList<Integer> factorList = new ArrayList<>();
        for (int i = 6; i < num; i++) {
            factorList.clear();
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    factorList.add(j);
                }
            }
            sum = 0;
            for (int h = 0; h < factorList.size(); h++) {
                sum = sum + factorList.get(h);
            }
            if (sum == i) {
                perfectList.add(i);
            }

        }
        System.out.println("The Perfect numbers upto 1000 are : ");
        for (Integer item : perfectList) {
            System.out.print(item + "/t");
        }
    }
}