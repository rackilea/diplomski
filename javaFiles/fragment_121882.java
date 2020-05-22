ShipmentRequest shipmentRequest = new ShipmentRequest();
shipmentRequest.setOrderItemId("1234567890");
shipmentRequest.setShipmentReference("A321SR");
ShipmentRequest.Transport transport = new ShipmentRequest.Transport();
transport.setTrackAndTrace("3SBOL0987654321");
transport.setTransporterCode("TNT");
shipmentRequest.setTransport(transport);

String jsonRequest = new Gson().toJson(shipmentRequest);
RequestBodyEntity result = Unirest.post("https://plazaapi.bol.com/services/rest/shipments/v2")
    .queryString(
       "access_token",
       "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOjMzMTgsInNlcSI6MSwidHlwIjoiYXBpIiwidnNuIjoxLCJuYmYiOjE1MTcyOTc2NjF9.hVdtwBfJAVfRVeBdf1XDAxe7Qpigwa0wmCvnF_Bicc8")
    .body(jsonRequest);
System.out.println(new Gson().fromJson(result.getBody().toString(), ShipmentRequest.class));