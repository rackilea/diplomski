public static void main(String[] args) throws FileNotFoundException {
    Gson gson = new Gson();
    JsonReader reader = new JsonReader(new FileReader("pathToJson.json"));
    Response res = gson.fromJson(reader, Response.class);
    for (Map<String, Device> map : res.Device_details) {
        for (Map.Entry<String,Device> e : map.entrySet()){
            System.out.println("Device : " + e.getKey());
            Device device = e.getValue();
            System.out.println("Interface : " + device.Interface);
            System.out.println("IP_address : " + device.IP_address);
        }
    }
}

class Device {
    String Interface;
    String IP_address;
}


class Response {
    List<HashMap<String, Device>> Device_details = new ArrayList();
}