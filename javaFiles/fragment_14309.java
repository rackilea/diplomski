public void addVehicle(Coordinator coordinator, String s1, String s2) {
    coordinator.notifyAndAddRow(new Object[]{s1, s2});
}

public void removeVehicle(Coordinator coordinator, int index) {
    coordinator.notifyAndDeleteRow(index);
}