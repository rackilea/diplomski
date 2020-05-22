for (int i = 0; i < 4; i++) {
    System.out.print("Enter the best time available for person " + (i+1) + ".");
    p=kbd.nextInt();
    if (p == 1) morning++;
    else if (p == 2) noon++;
    else if (p == 3) evening++;
}