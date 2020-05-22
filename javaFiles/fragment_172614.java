import javax.swing.JOptionPane;

[...]

public static void main(String[] args) {

    int numberOfRentals, finalBill;

    VideoRental rental = new VideoRental(); //runs constructor

    String renterName;
    renterName = JOptionPane.showInputDialog(null, "Enter renter name: ");

    numberOfRentals = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of videos to rent: "));

    rental.setRentalFee();  //needs to set rental fee to $5 according to assignment
    rental.calculateBill(numberOfRentals);  //from prev input
    finalBill = rental.getFinalBill();

    JOptionPane.showMessageDialog(null, renterName + " your total bill for " +numberOfRentals+ " videos is $" +finalBill);
  }