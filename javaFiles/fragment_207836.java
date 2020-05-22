Map<String, String> departments = new HashMap<String, String>();
String findKey = "CSC1";
departments.put("CSC", "CSC 110 Fundamentals of Programming I");
departments.put("PHYS", "PHYS 102 General Physics");
departments.put("MATH", "MATH 100 Calculus I");

if(departments.containsKey(findKey))
{
    System.out.println( findKey + " --- " + departments.get(findKey));
}
else
{
    System.out.println("Invalid Couse");
}