ObjectMapper om = new ObjectMapper();
String json = om.writeValueAsString(new CarRentalStation());
System.out.println(json);
// prints: {"location":"Atlanta","cars":[{"vin":"B321","model":"Volkswagen Golf 2.0 TDI"},{"vin":"A123","model":"BMW 120d"}]}

CarRentalStation deserializedCarRentalStation =  om.readValue(json, CarRentalStation.class);
System.out.println(deserializedCarRentalStation.toString());
// prints: CarRentalStation{location='Atlanta', cars={B321=Car{vin='B321', model='Volkswagen Golf 2.0 TDI'}, A123=Car{vin='A123', model='BMW 120d'}}}