public class TomAndJerry {
    private static Scanner sc = new Scanner(System.in);

    public String catAndMouse(int x, int y, int z) {
        String result;
        if (Math.abs(x - z) < Math.abs(y - z)) {
            result = "Cat A";
        } else if (Math.abs(x - z) > Math.abs(y - z)) {
            result = "Cat B";
        } else {
            result = "Mouse C";
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println("enter the number of queries");
        int q = sc.nextInt();
        int x , y , z ;
        String result;
        TomAndJerry tj = new TomAndJerry();
        for (int i = 0; i < q; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            result = tj.catAndMouse(x, y, z);
            System.out.println(result);
        }
    }
}