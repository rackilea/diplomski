ObjectMapper objectMapper = new ObjectMapper();

String carJson =
"{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

try {
Vehicle vehicle= objectMapper.readValue(carJson, Vehicle.class);

System.out.println("car brand = " + vehicle.getBrand());
System.out.println("car doors = " + vehicle.getDoors());
} catch (IOException e) {
e.printStackTrace();
}