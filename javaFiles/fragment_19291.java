class Student {
   @OneToMany(mappedBy = "student");
   List<StudentUniqueInfo> studentUniqueInfoList;

   @OneToMany(mappedBy = "student");
   List<StudentOtherInfo> studentOtherInfoList;
   ...
}