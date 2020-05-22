while(docs.next) {
   String file1Data = null;
   String file2Data = null;
   if(docs.getString("fileType").equals("file1")) {
   // assign value for fiel1Data here
   } 
   if(docs.getString("fileType").equals("file2")) {
   // assign value for fiel2Data here
   }
   System.out.println("<tr>");
   System.out.println("<td>" + (file1Data == null || file1Data.equals("")?"-" : file1Data) + "</td>");
   System.out.println("<td>" + (file2Data == null || file2Data.equals("")?"-" : file2Data) + "</td>");
   System.out.println("</tr>");
}