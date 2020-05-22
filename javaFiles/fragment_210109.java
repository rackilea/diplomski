class BDDObject {
...
    @Override
    public String toString() {
        return String.valueOf(getValue(IDDConstants.IDD_THERAPY_AREA_REF_VALUE)).toLowerCase().trim() + 
            String.valueOf(getValue(IDDConstants.IDD_THERAPY_AREA_REF_TYPE_NAME)).toLowerCase().trim());
}