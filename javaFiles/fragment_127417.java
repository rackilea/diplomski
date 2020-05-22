class MyService {
    CrsService crsService;
    UnitService unitService;

public Unit getUnitSymbolForCRSCode(Integer crsCode) {  
    String crsUnitName = crsService.getCrsByCode(crsCode).getUnitName();
    return unitService.getUnits().stream()
                    .filter(u->u.getUnitOfMeasureName().equalsIgnoreCase(crsUnitName))
                    .findFirst()
                    .orElseThrow(() -> 
                                 new DataNotFoundException(String.format(
                                     "Failed to retrieve unit details for %s.",crsUnitName));
}