List<String> departments = new ArrayList<String>();
String findKey = "CSC1";
departments.add("CSC 110 Fundamentals of Programming I");
departments.add("PHYS 102 General Physics");
departments.add("CSC 167 Video Game Interaction and Design");
boolean found = false;
for(String department : departments)
{
    if(department.startsWith(findKey))
    {
        found = true;
        System.out.println(department);
    }
}
if(!found)
{
    System.out.println("Invalid Cource");
}