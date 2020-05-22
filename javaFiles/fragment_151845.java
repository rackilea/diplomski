Scanner scanner = new Scanner(System.in);

// Get number of courses.
System.out.print("Ders sayısını giriniz: ");
int numberOfCourses = scanner.nextInt();

float[] grades = new float[numberOfCourses];
int[] akts = new int[numberOfCourses];

// Get grades.
System.out.println("Notları, gireceğiniz akts sırasıyla giriniz!");
for (int i = 0; i < numberOfCourses; i++)
{
    System.out.printf("%d.not : ", i + 1);
    grades[i] = scanner.nextFloat();
}

// Get akts.
System.out.println("Notları girdiğiniz sıra ile, akts lerini giriniz.!");
for (int i = 0; i < numberOfCourses; i++)
{
    System.out.printf("%d.akts : ", i + 1);
    akts[i] = scanner.nextInt();
}

// Calculate result.
float result = 0;
int aktsSum = 0;
for (int i = 0; i < numberOfCourses; i++)
{
    result += grades[i] * akts[i];
    aktsSum += akts[i];
}
result /= aktsSum;

System.out.println(result);