//List of query
ArrayList<String> queryList = new ArrayList<String>();
...
while ((s = d.readLine()) != null){
                        String[] name = s.split("\"");

                        String[] arrIdTemp = s.split("=");
                        String[] arrtId = arrIdTemp[0].split("a");

                        queryList.add("INSERT INTO " + Constant.DB.DB_NAME
                                + " Values ('" + arrtId[1] + "','" + name[1]
                                + "');");

                    }

...

if (queryList!=null && queryList.size()>0){
                Iterator<String> iter = queryList.iterator();
                db.beginTransaction();
                try {
                    while (iter.hasNext()) {
                         db.execSQL(iter.next());
                        }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
            }