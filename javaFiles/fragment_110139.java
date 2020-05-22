if (c != null ) {
                if  (c.moveToFirst()) {
                    do {
                    String id = c.getString(c.getColumnIndex("KEY_ID"));
                    // System.out.println("this is first activity"+firstName);
                    String firstName = c.getString(c.getColumnIndex("First_Name"));
                    String lastName = c.getString(c.getColumnIndex("Last_Name"));
                        //System.out.println("this is first activity====age"+age);
                        results.add("" + firstName + ",lastName: " + lastName);
                    }while (c.moveToNext());
                } 
            }

            this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,results));