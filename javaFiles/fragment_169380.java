response += "HTTP/1.1 200 OK\n";
response += "Content-Type: application/xml\n\n";

if ( format.equals("xml")){
      // Retrieve XML Document
       String xml = LotFromDB.getParkingLotXML();
       response += xml;
}