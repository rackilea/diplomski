public String findFilteredSql(String queryFilter, SearchBean searchBean) {
    if (searchBean.getSupplierId() != null) {
        queryFilter += " JOIN SUPPLIER_COMMODITY sc ON sc.SUPPLIERID = v.SUPPLIERID ";
    }

    [...]
}