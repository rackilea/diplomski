class ExceptionA  {

   public enum codes {
        CODE1("CODE1"),
        CODE2("CODE2"),
        CODE3("CODE3"),

       private String code;

      codes(String code){
          this.code = code;
      }

      public String getCode() {
          return this.code;
      }  
   }
   public static final String faultCode1 = code.CODE1;
   public static final String faultCode2 = code.CODE2;
   public static final String faultCode3 = code.CODE3;

}