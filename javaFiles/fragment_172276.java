response.setContentType("text/csv;charset=utf-8")
response.setHeader("Content-Disposition","attachment; filename=\yourData.csv\"");


OutputStream resOs= response.getOutputStream();  
OutputStream buffOs= new BufferedOutputStream(resOs);   
OutputStreamWriter outputwriter = new OutputStreamWriter(buffOs);  

CsvWriter writer = new CsvWriter(outputwriter);  

 // write data in csvwrite in loop