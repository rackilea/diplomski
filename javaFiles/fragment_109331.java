class CsvEntity {
     private String OCCURRENCES,STATUS,MESSAGE,STACK_TRACE;

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         CsvEntity csvEntity = (CsvEntity) o;
         return Objects.equals(MESSAGE, csvEntity.MESSAGE) &&
                 Objects.equals(STACK_TRACE, csvEntity.STACK_TRACE);
     }

     @Override
     public int hashCode() {
         return Objects.hash(MESSAGE, STACK_TRACE);
     }

     public CsvEntity(String OCCURRENCES, String STATUS, 
                  String MESSAGE, String STACK_TRACE) { ... }
     ...
     ...
     ...
}