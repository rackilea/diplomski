public abstract class EmployeeCardFileGenerator {
   /**
   * @return the generated file name
   */
   public abstract String getFileName(/*any params you need to get the file name*/);

   /**
   * @return the line corresponding to the given data record
   */
   public abstract String getLine(EmployeeCardData data);

   /**
   * @return the header to be appended at the beginning of the file
   */      
   public abstract String getHeader(/*any header params*/);

   /**
   * @return the footer to be appended at the end of the file
   */
   public abstract String getFooter(/*any footer params*/);

   public void generateFile(/*any params*/) {
      List<EmployeeCardData> data = queryData();

      File f = createFile();
      PrintWriter pw = getWriter(f);
      pw.println(getHeader());

      for(EmployeeCardData ec : data) {
          pw.println(getLine(ec));
      }

      pw.println(getFooter());

      cleanup();
   }
}