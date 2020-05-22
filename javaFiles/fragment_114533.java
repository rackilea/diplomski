UUID uuid = UUID.randomUUID()
//long lTimeStamp = d.getTime();
String tableInsert = "INSERT INTO tblTest (guidField,strField,dateField)" +
                              " VALUES ('" + uuid + "'"
                                        ",'test'" +
                                        ", getdate()"
                                        ")";
sql.execute(tableInsert);