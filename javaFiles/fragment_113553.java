PreparedStatement statement=DataBaseConnector.getConnection().prepareStatement(
        "INSERT INTO goods (item_title, item_descr, item_email, item_phone, item_images, item_price)
        VALUES ( ? , ? , ? , ? , ? , ? )");
int index=1;
statement.setString(index++,item.title.trim());
statement.setString(index++,item.descr.trim());
statement.setString(index++,+item.email.trim());
statement.setString(index++,item.phone); //Assuming it is a String
statement.setArray(index++,item.images);
statement.setDouble(index++,item.price); //Assuming it is a Double
int rowsUpdated = statement.executeUpdate()