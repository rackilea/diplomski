//Create a new map of values, where column names are the keys
                            ContentValues values = new ContentValues();

                            for (Collection collection : td.getCollections()) {

                                values.put("reminders", collection.getNumberOfReminders());
                        }