String where = FileColumns.DATA + " like " + "XYZ";

      cursor =    Context.getContentResolver().query(Files.getContentUri("external"),
                        projection, // Which columns you need
                        where, null
                        }, null);