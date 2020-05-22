do {
  do {
    System.out.println("Please enter full time employee payscale level 1 rate:");
    fullTimePay1 = input.nextInt();
  } while (fullTimePay1 < 65000);
  do {
    System.out.println("Please enter full time employee payscale level 2 rate:");
    fullTimePay2 = input.nextInt();
  } while (fullTimePay2 < 60000);
} while (fullTimePay1 < (fullTimePay2 * 1.1));