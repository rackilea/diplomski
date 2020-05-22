Map<String, String> departmentNames = new HashMap<String, String>();
departmentNames.put("PROG_DEPT", "PROGRAMMING/ENGINEERING");
departmentNames.put("DES_DEPT", "DESIGN/WRITING");
//...etc...

//...

String dept = "PROG_DEPT";
String deptName = departmentNames.get(dept);
System.out.println(deptName); //outputs "PROGRAMMING/ENGINEERING"