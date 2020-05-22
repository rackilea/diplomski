class FixedUnitService implements UnitService {
    public List<Unit> getUnits() {
        List<Unit> unitList= new ArrayList<Unit>();
        unitList.add(new Unit("dega","Degree"));
        unitList.add(new Unit("ft[US]","US Survey foot"));
        unitList.add(new Unit("m","Meter"));
        unitList.add(new Unit("ft[Se]","Sear's Foot"));
        unitList.add(new Unit("ft[GC]","Gold Coast Foot"));
        unitList.add(new Unit("ft","International Foot"));      
        unitList.add(new Unit("link[Cla]","Clarke's Link"));
        unitList.add(new Unit("gon","Grad"));
        return unitList;
    }
}
class LookupCrsService implements CrsService {
    public Crs getCrsByCode(int id) {
        SearchResultResponse response = searchCode(String.valueOf(code), 180224);
        List<DisplayItem> crsDisplayItems = response.getDisplayItems();
        if (crsDisplayItems.isEmpty()) {
            throw new DataNotFoundException("CRS not found with code " + code + ": " + response.getSearchMessage());
        }
        return Util.convertToCrsVoList(crsDisplayItems).get(0);
    }
}