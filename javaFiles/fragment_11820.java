public class TsvResponse {
   private final String filename;
   private final List records;
    private final String[] columnTitles;

   public TsvResponse(List records, String filename, String ... columnTitles) {
       this.records = records;
       this.filename = filename;
       this.columnTitles = columnTitles;
   }
   public String getFilename() {
       return filename;
   }
   public List getRecords() {
       return records;
   }

    public String[] getColumnTitles() {
        return columnTitles;
    }
}