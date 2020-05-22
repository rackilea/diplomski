public static void main(String[] args) {
    ClassDetails C = new ClassDetails(args[0]);
      try
      {
          C.getClassDetails();
      }
      catch(ClassNotFoundException ex)
      {
          //Add exception handling here
      }
}