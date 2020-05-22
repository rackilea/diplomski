public static void main(String[] args) throws Exception {
    Student student = Student.class
                             .getConstructor(Integer.class, String.class, Boolean.class)
                             .newInstance(2452, "sfhfshsf", true);

    System.out.println(student);
}