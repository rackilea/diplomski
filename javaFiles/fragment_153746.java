ArrayList<MyClass> array = new ArrayList<MyClass>();

Iterator<MyClass> it1 = array.iterator(); 
while (it1.hasNext())
{ 
    MyClass temp = it1.myGetterMethod(); 
    System.out.println (temp); 
}