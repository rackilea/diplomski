class ClassRoom{
    private List<Student> al;
    public ClassRoom1(List<Student> studentList){
        a1 = new ArrayList(studentList);
    }

    public void addStudent(String name, String lastName, int age) {
        al.add(new Student(name, lastName, age));
    }

    public List<Student> getStudents(){
        return al;
    }

    public Iterator<Student> returnIter(){
        return getStudents().iterator();
    }
}