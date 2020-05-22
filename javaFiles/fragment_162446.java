public static void main(String[] args) {              
   StudentDetails.input();
   StudentDetails.display();        
}

...
static List<StudentDetails> sd = new ArrayList<>();
...
public static void input() {
    ...
    for (int i = 0; i < no; i++) {
        StudentDetails sDetails = new StudentDetails();
        System.out.println("Enter name of student" + (i + 1));
        sDetails.setNames(sc.next());
        System.out.println("Enter marks for same student");
        sDetails.setMarks(sc.nextInt());
        sd.add(sDetails);    
    } 
    ...
}

public static void display() {
    ...
}