ObjectMapper mapper = new ObjectMapper(); 
ShipData[] shipDataArray  = mapper.readValue(jsonFile2, ShipData[].class);
//then you can look through the array
System.out.println("______________ History_________");
for(int x=0; x < shipDataArray.length(); x++){
     shiphistory = shipDataArray[x];
     System.out.println("Ship Name : " + shiphistory.getName());
     System.out.println("Ship MMSI : " + shiphistory.getMmsi());
     System.out.println("Ship Type : " + shiphistory.getShipType());
     System.out.println("Ship Departure : " + shiphistory.getTimeLastUpdate());
    //just a separating line (not necessary - just to separate the shipdata items
    System.out.println("-----------------------------------------------------");
}