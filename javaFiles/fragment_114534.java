String tableInsert = "INSERT INTO tblTest (guidField,strField,dateField)" +
                              " VALUES (newid()"
                                        ",'test'" +
                                        ", getdate()"
                                        ")";
sql.execute(tableInsert);