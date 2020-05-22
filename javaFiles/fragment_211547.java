Executor executor = Executors.newFixedThreadPool(3);
Future<List<Student>> studentsFuture = executor.submit(() -> return studentMao.getAll(collegeId));
Future<List<Department>> departmentsFuture = executor.submit(() -> return departmentsMao.getByCollegeId(collegeId));
Future<List<College>> collegesFuture = executor.submit(() -> return collegeMao.getByUniversityId(universityId));

List<Student> students = studentsFuture.get();
List<Department> departments = departmentsFuture.get();
List<College> colleges = collegesFuture.get();