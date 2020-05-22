PreparedStatement update = connection.prepareStatement(
    "UPDATE table SET field=? WHERE id=?");

PreparedSTatement insert = connection.prepareStatement(
    "INSERT INTO table (id, field) \n" +
    "       SELECT ?, ? \n" +
    "       WHERE NOT EXISTS (SELECT 1 FROM table WHERE id=?)";

update.setString(1, "C");
update.setInt(2, 3);
update.executeUpdate();

insert.setInt(1, 3);
insert.setString(2, "C");
insert.setInt(3, 3);
insert.executeUpdate();

connection.commit();