public class External {
   private List<External.Internal> parent;
   private String prop2; 

   @JsonRootName("parent")
   public static class Internal {
     private List<Integer> property;
     private Integer type;
   }
}