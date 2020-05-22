public enum DepartmentsAndFaculties
{
   UN (null, "UN", "University"),
   EF (UN,   "EF", "Engineering Faculty"),
   CS (EF,   "CS", "Computer Science & Engineering"),
   EE (EF,   "EE", "Electrical Engineering");

   private final DepartmentsAndFaculties parent;
   private final String code, title;

   DepartmentsAndFaculties(DepartmentsAndFaculties parent, String code, String title)
   {
       this.parent = parent;
       this.code   = code;
       this.title  = title;
   }

   public DepartmentsAndFaculties getParent()
   {
       return parent;
   }

   public String getCode()
   {
       return code;
   }

   public String getTitle()
   {
       return title;
   }
}