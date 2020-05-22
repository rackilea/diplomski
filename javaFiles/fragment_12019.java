@Override
public boolean equals(Object obj) {
   if(!obj instanceof Employee) {
      return false;
   }
   Employee e = (Employee) obj;
   // Add more fields to compare if necessary
   return this.getEmployeeId().equals(e.getEmployeeId()) && this.getAge().equals(e.getAge()); 
 }