do {
  System.out.println("Please enter full time employee payscale level 1 rate:");
  fullTimePay1 = input.nextInt();
} while (fullTimePay1 < 66000); // 'cause min(1) = 1.1*min(2) = 1.1*60000 = 66000
do {
  System.out.println("Please enter full time employee payscale level 2 rate:");
  fullTimePay2 = input.nextInt();
} while (fullTimePay2 < 60000 || fullTimePay1 < (fullTimePay2 * 1.1));