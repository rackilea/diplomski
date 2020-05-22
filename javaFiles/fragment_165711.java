for( VehicleReportRow vehicleReportRow : unpreparedRows ){
    String vehicle = vehicleReportRow.getVehicle();
    String name = vehicleReportRow.getName();
    String property = vehicleReportRow.getProperty();
    String value = vehicleReportRow.getValue();

    // check if we have an outermost entry for this vehicle type and if not then
    // create one and store it in vehiclesData so that next time we can get the same
    // map for this vehicle type
    HashMap<String, HashMap<String,String>> nameToProps = vehiclesData.get(vehicle);;
    if (nameToProps == null) {
        nameToProps = new HashMap<String, HashMap<String,String>>();
        vehiclesData.put(vehicle, nameToProps);
    }

    // similarly, check if we already have a props to values map for this name
    // and create and store one if not
    HashMap<String,String> propAndVal = nameToProps.get(name);
    if (propAndVal == null) {
        propAndVal = new HashMap<String, String>();
        nameToProps.put(name, propAndVal);
    }

    // store the property and value
    propAndVal.put(property, value);
}