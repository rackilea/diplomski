ArrayList<ArrayList<String>> module_list = new ArrayList<ArrayList<String>>();
        ArrayList<String> new_row = new ArrayList<String>();

        new_row.add(module_description,"Description0");
        new_row.add(module_address, "Address0");
        new_row.add(module_type, "Type0");
        module_list.add(0,new_row);

        new_row = new ArrayList<String>();
        new_row.add(module_description, "Description1");
        new_row.add(module_address,"Address1");
        new_row.add(module_type, "Type1");
        module_list.add(1,new_row);

        new_row = new ArrayList<String>();
        new_row.add(module_description, "Description2");
        new_row.add(module_address, "Address2");
        new_row.add(module_type,"Type2");;
        module_list.add(2, new_row);


        for(int row = 0; row<module_list.size() ; row++) {
            ArrayList<String> returned_row = new ArrayList<String>();
            returned_row = module_list.get(row);

            Log.d("APP", "Row: "+ Integer.toString(row));
            Log.d("APP", "Module description: " + returned_row.get(module_description));
            Log.d("APP", "Module address: " + returned_row.get(module_address));
            Log.d("APP", "Module type: " + returned_row.get(module_type));
        }