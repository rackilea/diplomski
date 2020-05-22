private Hashtable calcLookupTable(CompanyList _companyList) {
    Hashtable retval = new Hashtable();
    for (Enumeration e = _companyList.elements(); e.hasMoreElements();) {
        Company temp_comp = (Company) e.nextElement();
        Integer parent_id = temp_comp.getParentCompanyID();

        if (retval.containsKey(parent_id) == false) {
            retval.put(parent_id, new Vector());
        }
        retval.get(parent_id).add(temp_comp);
    }
    return retval;
}