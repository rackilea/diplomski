public class Hw7Pr2 {

    public static void main(String[] args) {
        int [] grades = {40, 55, 70, 58};        

        System.out.print("Best: ");
        int best1 = best(grades);
        System.out.print(best1);
    }

    public static int best(int[] grades){
        if (grades == null || grades.length < 1) { return -1; } //Should always check

        int best = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > best) {
                best = grades[i];
            }
        }
        return best;
    }
}