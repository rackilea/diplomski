public class CsvResponse {    
   private final String filename;
   private final List<CompositeRequirement> records;

   public CsvResponse(List<CompositeRequirement> records, String filename) {
       this.records = records;
       this.filename = filename;
   }
   public String getFilename() {
       return filename;
   }
   public List<CompositeRequirement> getRecords() {
       return records;
   }
}