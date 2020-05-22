public boolean equals(Object obj) {
   if (obj instanceof Student) {
     return studentID == ((Student)obj).getStudentID();
   }
  return false;
}

public int hashCode() {
   return studentID;
}