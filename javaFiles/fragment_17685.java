Scanner sc = new Scanner(System.in);
Course[] courses = new Course[3];
int i = 0;
while (i < courses.length) {
    System.out.print("What class are you rating? ");
    String className = sc.nextLine();
    System.out.printf("How many plus signs does %s get? ", className);
    int classRating = Integer.parseInt(sc.nextLine());
    courses[i] = new Course(className, classRating);
    i++;
}
i = 0;
while (i < courses.length) {
    System.out.println(courses[i]);
    i++;
}