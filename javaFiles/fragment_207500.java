int i = DistrictModel.getSize();
for (int p = 0; p < i; p++) {
    DistrictItem currentDistrictItem = (DistrictItem) DistrictModel.getElementAt(p);
    if (currentDistrictItem.getName().equals(name)) {
        DistrictCB.setSelectedIndex(p);
        break;
    }
}