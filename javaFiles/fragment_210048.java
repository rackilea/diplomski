Scanner input = new Scanner (System.in);
for (int j = 0; j < 5; j++) {
    System.out.printf("Student %s: ", j+1);
    int num = input.nextInt();
    if (num >= 0 && num <= 100)
        studentGrade[j][1] = num;
    else {
        studentGrade[j][1] = 0;
        System.out.printf("Student %s's mark has been defaulted", j+1);
    }
}