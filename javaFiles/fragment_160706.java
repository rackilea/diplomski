public static Collection<Integers> Searchdep(EmployeeClass EmployeeArr[], String department, int size)  {
   List<Integer> intList = new ArrayList<Integer>();
   for(int i=0; i<size; i++)
   {
      if(EmployeeArr[i].Department.equals(department)) {
          intList.add(i);
      }
   }
   return intList;
}