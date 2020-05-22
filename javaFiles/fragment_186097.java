System.out.print("Enter Grade Size: ");
int gradeSize = input.nextInt();

int passCount = 0;
int grades[]=new int[gradeSize];
System.out.println();
System.out.print("Enter Grades: ");
for (int i = 0; i < gradeSize; i++) {
  grades[i] = input.nextInt();
  if(grades[i] >= 75) { 
    passCount++;
  }
}
int passGrade[] = new int[passCount];
int failGrade[] = new int[grades.length - passCount];
int failCount = passCount = 0;
for (int grade : grades) {
  if (grade >= 75) { 
    passGrade[passCount++] = grade;
  } else {
    failGrade[failCount++] = grade;
  }
}
System.out.println("Passing Grades: " + Arrays.toString(passGrade));
System.out.println("Failing Grades: " + Arrays.toString(failGrade));