private static HashMap<String, EmployeeType> employeeTypeTranslations = new HashMap<String,EmployeeType> () {{
  put("a",EmployeeType.ADMIN);
  put("s",EmployeeType.SERVICE);
  put("1",EmployeeType.ADMIN);
  put("2",EmployeeType.SERVICE);

}};

public static EmployeeType decideEmployeeType(String class) {
        employeeTypeTranslations.get(class.toLowerCase());
    }