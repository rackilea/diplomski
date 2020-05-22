public class AA {

        public static void main(String[] args) {

                System.out.println(getNextShot(1, 9));

        }

        public static int getNextShot(int shotCount, int Countdown)
    {
        if ((shotCount == 1) && (Countdown != 10)) return 2;
        else if (shotCount == 0) return 1;
        else return -1;
    }
}