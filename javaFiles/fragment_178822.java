public enum TenWords{
     ZERO(""), TEN("ten"), TWENTY("twenty"), THIRTY("thirty");

     private final String value;
     private TenWords(String value) {
       this.value = value;
     }
     public String getValue() {
       return value;
     }
}