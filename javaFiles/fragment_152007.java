public class Tester {
    public static void main(String[] args) throws Exception {
        // Creating Dummy Variables
        Student student1 = new Student();
        student1.name = "Test";
        student1.biologyCourse = "Yes";
        Student student2 = new Student();
        student2.name = "Test1";
        student2.address = "abc street";
        Counter counter = new Counter();

        // Comparing Students
        Solution solution = new Solution();
        solution.compareStudents(student1, student2, counter);

        // Printing Counter
        System.out.println(counter);
    }
}