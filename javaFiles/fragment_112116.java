public class LockerFun {
    public static void main(String[] args) {
        final int numberOfStudents = 100;
        boolean[] lockers = new boolean[101];

        for (int i = 1; i < lockers.length; i++)
            lockers[i] = true;

        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.print(String.format("%4d", i));
            for (int j = 1; j < lockers.length; j++) {
                if (j % i == 0) {
                    lockers[j] = !lockers[j];
                }
            }
        }

        System.out.println();
        for (int i = 1; i < lockers.length; i++) {
            if (lockers[i])
                System.out.print(String.format("%4s", "X"));
            else
                System.out.print(String.format("%4s", "O"));
        }
    }
}