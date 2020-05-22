public class OptimalIncome {
    final static int length[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    final static int price[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
    public static int totalLength = 9;
    static List<Integer> pickedObjects = new ArrayList<Integer>();
    public static int bestCut(int i, int totalLength) {
        if (i < 0) {
            return 0;
        } else if (length[i] > totalLength) {
            return bestCut(i - 1, totalLength);
        } else {
            return Math.max(bestCut(i - 1, totalLength),
                    bestCut(i - 1, totalLength - length[i]) + price[i]);
        }
    }

    public static void printSolution(int i,int totalLength){
        if(i < 0)
            return;
        else if(length[i]>totalLength){
            printSolution(i-1, totalLength);
        }else{
            int sol1 = bestCut(i-1,totalLength);
            int sol2 = bestCut(i - 1, totalLength - length[i]) + price[i];
            // check whether the optimal solution coming from picking the object or not .
            if(sol1>sol2){
                printSolution(i-1, totalLength);
            }else{

                pickedObjects.add(i);
                printSolution(i-1, totalLength - length[i]);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Given total rod length : " + totalLength);
        System.out.println("Maximum income         : "
                + bestCut(price.length - 1, totalLength));
        System.out.println("Smaller part sets      : ");
        printSolution(price.length-1, totalLength);
        for (Integer i : pickedObjects) {
            System.out.println("picked object: "+ i +" length : "+ length[i]+ " price "+ price[i]);
        }
    }
}