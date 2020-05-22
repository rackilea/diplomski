Map<String, Integer> studentsInDepartments = new HashMap<String, Integer>();

for (Student student : students) {
    String department = student.getDepartment();
    if (studentsInDepartments.containsKey(department)) {
        studentsInDepartments.put(department, studentsInDepartments.get(department) + 1);
    } else {
        studentsInDepartments.put(department, 1);
    }
}

for (String key : studentsInDepartments.keySet()) {
    Department department = new Department();
    department.setName(key);
    department.setStudentCount(studentsInDepartments.get(key));
}