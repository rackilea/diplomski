URL http = new URL(url +"/"+ m_printfile.get(i));
URLConnection conn = http.openConnection();
conn.setUseCaches(false);
conn.connect();
Doc myDoc = new SimpleDoc(conn.getInputStream(), myFormat, das);
DocPrintJob job = service.createPrintJob();
job.print(myDoc, aset);