int getInt() {
    try {
        String[] students = {"student1", "student2"};
        System.out.println(students[4]);
        // no return
    }
    catch (Exception e) {
        return 10; // if an exception occurs 
    }
    // no return
}