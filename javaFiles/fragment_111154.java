EquipmentService#saveEquipment(Equipment e, Sting type, String modelName){
    EquipmentType t = findType();
    Model m = findModel();
    e.setType(t);
    e.setModel(m);
}