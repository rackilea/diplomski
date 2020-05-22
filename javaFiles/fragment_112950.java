public class Hundred {

    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(100);
        x.add(200);
        x.add(300);
        x.add(400);
        x.add(454);

        for (Integer xx : x) {
            int nearest = ((xx - 1) / 100) * 100 + 1;
            System.out.println(nearest);
        }
    }
}