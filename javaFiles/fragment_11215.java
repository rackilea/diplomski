public class BabysittingJob {

    private int jobNumber;
    private int babysitterCode;
    private String babysitter;
    private int childrenNumber;
    private int hoursWorked;
    private double fee;

    public BabysittingJob(int year, int sequentialNumber, int babysitterCode, int childrenNumber, int hoursWorked, String babysitter) {
        year = year % 2000;
        this.childrenNumber = childrenNumber;
        this.hoursWorked = hoursWorked;
        this.babysitterCode = babysitterCode;
        this.jobNumber = ((year * 10000) + sequentialNumber);

        if (babysitterCode == 1) {
            this.babysitter = "Cindy";
        } else if (babysitterCode == 2) {
            this.babysitter = "Greg";
        } else if (babysitterCode == 3) {
            this.babysitter = "Marcia";
        }

        if (babysitterCode == 1) {
            this.fee = hoursWorked * 7 * childrenNumber;
        } else if (babysitterCode > 1 && childrenNumber == 1) {
            this.fee = hoursWorked * 9 * childrenNumber;
        } else if (babysitterCode > 1 && childrenNumber > 1) {
            this.fee = (hoursWorked * 9) + ((--childrenNumber) * hoursWorked * 4);
        }
    }
}