public class WinningBig {
    static int totalQuarters = 100;
    static int totalPlays = 0;
    static int machineOnePlays = 0;
    static int machineTwoPlays = 0;
    static int machineThreePlays = 0;

    public static void main(String[] args) {
        while (true) {
            if (totalQuarters > 0) {
                displayMachineOne();
                machineOnePlays++;
                totalPlays++;
                totalQuarters--;

            }
            if (totalQuarters > 0) {
                displayMachineTwo();
                machineTwoPlays++;
                totalPlays++;
                totalQuarters--;
            }
            if (totalQuarters > 0) {
                displayMachineThree();
                machineThreePlays++;
                totalPlays++;
                totalQuarters--;
            } else {
                System.out.println("Vickie lost all of her money! it took    " +
                        totalPlays + " plays for her to go broke");
                return;
            }
        }
    }

    public static void displayMachineOne() {

        if (machineOnePlays == 35) {

            totalQuarters += 25;
            machineOnePlays = 0;

            System.out.println("Vickie won on Machine One in the amount of 25 quarters, her total is now " + (totalQuarters - 1) * .25);

        }

    }

    public static void displayMachineTwo() {


        if (machineTwoPlays == 100) {

            totalQuarters += 75;
            machineTwoPlays = 0;

            System.out.println("Vickie won on Machine One in the amount of 75 quarters, her total is now " + (totalQuarters - 1) * .25);

        }
    }

    public static void displayMachineThree() {


        if (machineThreePlays == 8) {
            totalQuarters += 5;
            machineThreePlays = 0;

            System.out.println("Vickie won on Machine One in the amount of 5 quarters, her total is now " + (totalQuarters - 1) * .25);

        }
    }
}