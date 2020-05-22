public void selectSingleRow(ActionEvent event) {
    String vehicleName = (String) event.getComponent().getAttributes().get("selectedVehicleName");
    for (Vehicle v : vehicleList) {
          if (!v.getVehicleName.equals(vehicleName)) {
               v.setSelected(false);     
          }
    } 
}