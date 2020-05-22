Collection<Integer> returnedCollection = EmployeeClass.SearchDep(EmpList,department,count);
if(returnedCollection.isEmpty()){
   JOptionPane.showMessageDialog(null,"Nothing was found");     
} else {
   StringBuilder  str = new StringBuilder();
   for(Integer integer: returnedCollection){
       str.appened(EmpList[integer].ReturnStringInfo());
       str.appened(", ");
   }
   JOptionPane.showMessageDialog(null,"Indexed are : "+ str.toString());     
}