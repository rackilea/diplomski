Cursor cursor = db.rawQuery("SELECT modulename, modulelecturetime, moduleseminartime" +
                             " FROM " + Table2 +
                            " WHERE modulename=?" +
                               " OR modulename=?" +
                               " OR modulename=?" +
                              " AND (modulelecturedate=?" +
                                " OR moduleseminardate=?)",
                            new String[]{module1, module2, module3, day});