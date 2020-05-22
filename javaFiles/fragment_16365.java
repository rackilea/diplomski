QName qname = new QName("http://ws.eoddata.com/Data", "Data"); 
Data data = new Data(new URL("http://ws.eoddata.com/data.asmx?wsdl"), qname); 
DataSoap dataSoap = data.getDataSoap();
LOGINRESPONSE response = dataSoap.login("xxx", "ppp");

System.out.println(response.getMessage());