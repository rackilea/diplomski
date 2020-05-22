static LinkedList<Shipment> matrixToList() {
    LinkedList<Shipment> result = new LinkedList<>();
    for (List<Shipment> row : matrix) {
        for (Shipment shipment : row) {
            if (shipment != null) {
                result.add(shipment );
            }
        }
    }
    return result;
}