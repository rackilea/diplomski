List<DynaBean> rowsList=this._mysqlDb.foobar();
    Date timeStamp=null;
    for (int i=0;i<rowsList.size();i++) {
        DynaBean row = rowsList.get(i);
        try {
         timeStamp = this._mysqlDb.sqlTimestampToDate((java.sql.Timestamp)row.get("end_timestamp"));
        } catch (IllegalArgumentException e) {
            log.error("could not find properties: {}",e.getMessage());
            return false;
        }
}