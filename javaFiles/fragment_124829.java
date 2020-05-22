public static void main( String[] args )
{
   List<Employee> l1 = new ArrayList<Employee>();
   l1.add(new Employee(1));
   l1.add(new Employee(2));
   l1.add(new Employee(3));
   l1.add(new Employee(4));
   l1.add(new Employee(5));


   List<Employee> l2 = new ArrayList<Employee>();
   l2.add(new Employee(4));
   l2.add(new Employee(5));


   l1.removeAll(l2);
   System.out.println(l1);

}