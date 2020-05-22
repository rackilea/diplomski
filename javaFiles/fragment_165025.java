public class Control {

    private static Scanner sc;     //Making sc as a field variable so that we no longer need to explicitly close the resource 

    public static void main(String[] args) {
        System.out.println("Please enter your data \n\n\n");
        sc = new Scanner(System.in);
        List<Student> studs = new ArrayList<Student>();

        // Asking the user to enter number of records he/she wishes to enter
        System.out.println("How many records would you like to enter : ");

        for(int  i  = sc.nextInt(); i > 0 ; i--){

            System.out.println("Please enter the Name : ");  //Asking user for the name
            String name = sc.next();

            System.out.println("Please enter the age of "+name+" :");  //Asking user for the age of that specific name
            int age = sc.nextInt();

            studs.add(new Student(age,name));
        }

        Collections.sort(studs,new StudAge());
        for(Student stud : studs) {
            System.out.println(stud);
        }


    }

}