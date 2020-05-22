public class Car {
            public String brand = null;
            public int    doors = 0;
   // add getter and setter

        }

String json = "{\"brand\":\"Jeep\", \"doors\": 3}";

Gson gson = new Gson();

Car car = gson.fromJson(json, Car.class);