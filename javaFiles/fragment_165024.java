public class Control {

        private static Scanner sc;     //Making sc as a field variable so that we no longer need to explicitly close the resource 

        public static void main(String[] args) {
            System.out.println("Please enter your data ");
            sc = new Scanner(System.in);
            List<Student> studs = new ArrayList<Student>();
            Student stu1 = new Student(sc.nextInt(),sc.nextLine());  //Dynamically asking user to input age and name

            System.out.println("Please enter the Age and Name of the first user : ");
            Student stu2 = new Student(sc.nextInt(),sc.nextLine());

            System.out.println("Please enter the Age and Name of the second user : ");
            Student stu3 = new Student(sc.nextInt(),sc.nextLine());

            System.out.println("Please enter the Age and Name of the third user : ");
            Student stu4 = new Student(sc.nextInt(),sc.nextLine());

            studs.add(stu1);
            studs.add(stu2);
            studs.add(stu3);
            studs.add(stu4);

            Collections.sort(studs,new StudAge());
            for(Student stud : studs) {
                System.out.println(stud);
            }


        }

}