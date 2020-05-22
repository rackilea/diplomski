BufferedReader reader = ...; // initialize the reader
String line = null;
Pattern p = Pattern.compile(regexData.getJobDataType1(),Pattern.CASE_INSENSITIVE);    
while ((line = reader.readLine()) != null)
{
     Matcher m = p.matcher(line);
     while (m.find()) {
            // Process the match
     }
}