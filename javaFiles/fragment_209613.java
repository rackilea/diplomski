stmt.execute("DELETE FROM requests_list WHERE UNIQUE_ID = '"
            + selected_ID + "'"); // this seems to work

    stmt.execute("TRUNCATE TABLE checkout_" + selected_ID); // also seems to
                                                            // work

    ResultSet all_gear = stmt
            .executeQuery("SELECT * FROM gear_master_list");

    List<String> gear_items = new ArrayList<>();
    while (all_gear.next()) {
        gear_items.add(all_gear.getString(5));
    }
    all_gear.close();

    for (String gear_item: gear_items){
        if (all_gear.getString(5).equals(selected_ID)) {
            stmt.execute("UPDATE gear_master_list SET STATUS = 'In Stock' WHERE ID_NUM = "
                    + all_gear.getInt(6));
        }
    }

    stmt.close();