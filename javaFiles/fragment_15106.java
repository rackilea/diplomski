int getInt() {
    try {
        String[] students = {"student1", "student2"};
        System.out.println(students[4]);
        // the return could be here as well
    }
    catch (Exception e) {
        return 10; // in case of failure
    }
    return 20; // in case of success
}