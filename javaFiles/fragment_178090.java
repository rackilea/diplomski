int height = 0;
while (True) {
    System.out.println("Enter a height within 0 and 23");
    height = s.nextInt();
    if (height < 0 || height > 23) {
        System.out.println("Please enter an integer within 0 and 23");
        continue;
    } else break;
}