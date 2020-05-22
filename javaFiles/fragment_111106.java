new ResultSetExtractor<Collection<Student>>() {
    @Override
    public Collection<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, Student> studentMap = new HashMap<>();

        while(rs.next()){
            Integer id = rs.getInt(0);
            Student student = studentMap.get(id);

            if (student == null) {
                String name = rs.getString(1);
                student = new Student(id, name); // additional constructor for Student class
                studentMap.put(id, student);
            }

            student.addMark(rs.getInt(3));
        }

        return studentMap.values();
    }
});