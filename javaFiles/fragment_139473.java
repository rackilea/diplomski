public ArrayList<Vehicle> getVehicleList(File fin) {
    ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

    // Taken for my convenience, you should read it from "File fin"
    InputStream ins = getResources().openRawResource(
            getResources().getIdentifier("raw/vehicle", "raw", getPackageName()));
    try {
        BufferedReader br = new BufferedReader(new InputStreamReader(ins));
        String line = null;

        int cursor = 0;
        while ((line = br.readLine()) != null) {
            if (line.contains("[VEHICLE")) {
                Vehicle v = new Vehicle();
                vehicleList.add(cursor, v);
            } else if (line.contains("[ENDVEHICLE")) {
                cursor++;
            } else {
                // read vehicle attributes here
                Vehicle v1 = vehicleList.get(cursor);
                String[] attr = line.split(">");
                if (attr != null && attr.length == 3) {
                    if (attr[1].contains("type")) {
                        v1.type = attr[2];
                    } else if (attr[1].contains("fuelUsage")) {
                        v1.fuelUsageMPG = attr[2];
                    } else if (attr[1].contains("speed")) {
                        v1.speed = attr[2];
                    }
                }
            }
        }
        return vehicleList;
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}