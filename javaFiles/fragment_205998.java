private static void displayVehicleData(String displayType) {
    boolean isFirst = true;

    for(int x = 0; x < vehicles.length; x++){

        switch(displayType) {

            case "Vehicles" : // List All Vehicles
                isFirst = printColumnHeaders(vehicles[x], false, isFirst);
                    System.out.println(vehicles[x].printSummaryOutput());

                break;
            case "Cars": // List All Cars
                    if(vehicles[x].getVehicleType().equals("American Car") || 
                        vehicles[x].getVehicleType().equals("Foreign Car")) {
                        isFirst = printColumnHeaders(vehicles[x], false, isFirst);
                        System.out.println(vehicles[x].printSummaryOutput());
                    }