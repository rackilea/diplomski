List<ArrayList<String>> objs = new ArrayList<ArrayList<String>>(); //use list of objs
for( int i = 0; i < numEmployees; i++ )
{
    //all the inputs

    ArrayList<String> obj = new ArrayList<String>();
    obj.add(employeeName);
    obj.add(employeeAddress);
    obj.add(hireDate);
    objs.add(obj);

}

for( int i = 0; i < numEmployees; i++ ) //for loop just to display
    System.out.println(objs.get(i)); //display each element here