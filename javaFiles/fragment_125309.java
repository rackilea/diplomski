String line = "@NamedNativeQuery(name = \"nativeSQL\", query = \"SELECT emp1.emp_id, emp1.name, emp1.manager_id, \"\n" + 
"+ \"emp1.dept_id, emp1.address_id \" + \"FROM EMP emp1, EMP emp2 \"\n" +
"+ \"WHERE ((emp2.EMP_ID = ?) AND (emp2.EMP_ID = emp1.MANAGER_ID))\", resultClass = Professor.class)\n";
Pattern pt = Pattern.compile("^\\s*@NamedNativeQuery\\(\\s*name\\s*=\\s*\"(.+)\"\\s*,\\s*query\\s*=\\s*\"(.+)\"\\s*,", Pattern.DOTALL);
Matcher m = pt.matcher(line);
if (m.find())
   System.out.println("name: [" + m.group(1) + "] query: [" + m.group(2) + ']');