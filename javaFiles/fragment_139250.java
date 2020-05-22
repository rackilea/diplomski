public void setMysqlDb(MysqlDb db) {
    this._mysqlDb=db;
    /* it seems that without forcing a setInstance on the class, whenever other classes
     * would try to getInstance(), variables that are supposed to be configured by the bean
     * would be empty. this resolves that issue
     */
    MysqlDb.setInstance(db);
}