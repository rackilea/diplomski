private String recordDelimiter = "~";

public static List<List<String>> parse(Reader reader) {

   List<List<String>> result = new ArrayList<List<String>>();
   List<String> record = new ArrayList<String>();
   boolean isFirstLine = true;

   while ((line = reader.readLine()) != null) {

      line = line.trim();

      if (line.length() == 0) {
        continue;  // we skip empty lines
      }

      if (delimiter.equals(line.trim()) {
        if (!isFirstLine) {
          result.add(record);
          record = new ArrayList<String>();
        } else {
          isFirstLine = false;   // we ignore a delimiter in the first line.
        }
        continue;
      } 

      record.add(line);
      isFirstLine = false;
   }

   if (!result.contains(record))
     result.add(record);   // in case the last line is not a separator

   return result;

}