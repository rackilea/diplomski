n = families.size();
    LOGGER.debug("Debugging " + n + " Families");
    Family f;
    for (int i = 0; i < n; i++) {
        unitNames = "";   // <----------- ADD THIS LINE
        f = families.get(i);
        LOGGER.debug("FamilyId = " + f.getFamilyId() + "; FamilyTitle = " + f.getFamilyTitle() + "; Tabla = " + f.getTabla());
        nu = f.getUnits().size();
        for (int j = 0; j < nu; j++) {
            unitNames = unitNames + f.getUnits().get(j).getParkUnitTitleAersa() + ",";
        }
        LOGGER.debug("Units included => " + unitNames);
    }