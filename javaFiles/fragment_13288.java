db.rs = pst.executeQuery();
if (db.rs.next()) {
    lblEventname.setText(db.rs.getString("eventname"));
    lbleventonclick.setText(db.rs.getString("eventtext"));
} else {
    // no rows were returned
    lblEventname.setText("No events");
}