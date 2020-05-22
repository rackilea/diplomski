public static void main(String[] args) {

String url =
    "http://services.gisgraphy.com/geocoding/geocode?address=89%20Rue%20Champoiseau%2C%20Tours&country=FR&format=JSON&postal=true";
Client client = Client.create();
WebResource webResource = client.resource(url);
ClientResponse response =
    webResource
        .accept("application/json")
        .header("Accept-Encoding","gzip")
        .header("Accept-Language", "arbit text")
        .get(ClientResponse.class);
String jsonString = response.getEntity(String.class);
System.out.println(jsonString.toString());
}