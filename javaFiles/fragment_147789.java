public class Main {
    /**
     * Gets a teacher but calls it an Object.
     *
     * @return an Object that happens to be a Teacher
     */
    public static Object getTeacher() {
        return new Teacher();
    }

    public static void main(String[] args) {
        /** A Teacher, and is declared as such */
        Teacher teacher = new Teacher();

        /**
         * Some Object, which just so happens to actually
         * be a Teacher (but the compiler can't see that)
         */
        Object something = getTeacher();

        MyClass mc = new MyClass();

        Student withTeacher = mc.assign(teacher);
        Student withoutTeacher = mc.assign(something);
    }
}