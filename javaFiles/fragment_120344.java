static VehicleModifier withColor(int colorX, int colorY) {
    return vehicle -> vehicle.setColor(colorX, colorY);  
}

static VehicleModifier withNumberPlate(String tag) {
    return vehicle -> vehicle.setNumberPlate(tag);  
}