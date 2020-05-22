for(int i = roadVehicles.length; i > 0; i--) {
    if (roadVehicles[i-1] != null) {
        roadVehicles[i] = roadVehicles[i-1];                
    }
}
roadVehicles[0] = car;