for (Family f : families) {
      LOGGER.debug("FamilyId = " + f.getFamilyId() + "; FamilyTitle = " + f.getFamilyTitle() + "; Tabla = " + f.getTabla());

    String unitNames = "";
    for (Unit unit : f.getUnits() {
        unitNames = unitNames + unit.getParkUnitTitleAersa() + ",";
    }
}