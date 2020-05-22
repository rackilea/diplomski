import java.util.*;

class ServersProblemSolver {
    public static void main(String[] args) {
        int[] serverDowntimes = {5, 3, 1, 8, 2, 4};

        int totalCost = Integer.MAX_VALUE;
        List<Integer> bestCombination = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, serverDowntimes.length); i++) {
            int temporaryCost = 0;
            int combination = i;
            int start = 0;
            int end = serverDowntimes.length - 1;
            List<Integer> temporaryCombination = new ArrayList<>();

            for (int k = 0; k < serverDowntimes.length; k++) {
                if (combination % 2 == 1) {
                    temporaryCost += (k + 1) * serverDowntimes[start];
                    temporaryCombination.add(serverDowntimes[start]);
                    start++;
                } else {
                    temporaryCost += (k + 1) * serverDowntimes[end];
                    temporaryCombination.add(serverDowntimes[end]);
                    end--;
                }
                combination /= 2;
            }

            System.out.println("combination " + i + ": " + temporaryCombination + ", cost : " + temporaryCost);

            if (temporaryCost < totalCost) {
                totalCost = temporaryCost;
                bestCombination = temporaryCombination;
            } else {
                temporaryCombination.clear();
            }
        }

        System.out.println("lowest cost: " + totalCost + ", with combination: " + bestCombination);
    }
}