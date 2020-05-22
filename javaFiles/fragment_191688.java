@RequestMapping("studentlist")
    public 
    WrapperList<Student> getStudentList() {
        List<Student> studentList = new ArrayList<Student>();
        // add students to the list and put them in wrapper class 
        WrapperList<Student> list = new WrapperList<Student>(studentList);
        return list;
    }