public class MyRequest {
   @NotNull
   private String customerId;

   @NotNull
   private String reason;

   @NotNull
   @NotEmpty
   private List<String> attributes;

   // getters and setters left out for brevity.
}