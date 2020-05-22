private static void deleteaStudent(int input){

    if (snumbers.contains(input)) {
        Iterator<Student> iter = students.iterator();
        while (iter.hasNext() {
            Student i = iter.next ();
            if(i.sNumber == input){
                iter.remove ();
                System.out.println(i.sNumber +" "+ i.firstName+" "+i.lastName + " has been deleted!");
            }
            else {
                System.out.println(" ");
            }
        }
    } else {
       System.out.println("Sorry, We cannot find a student with that number!");

    }
}