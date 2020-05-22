Iterator<Building> i = buildingsCache.iterator();
while (i.hasNext()) {
    Building b = i.next();
    b.setBuildingType("Whatever type");
    buildingComboBoxModel.addElement(b);
}