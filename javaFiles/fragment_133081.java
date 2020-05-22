// Get the Large Object Manager to perform operations with
LargeObjectManager lobj = ((org.postgresql.PGConnection)conn).getLargeObjectAPI();

PreparedStatement ps = conn.prepareStatement("SELECT imgoid FROM imageslo WHERE imgname = ?");
ps.setString(1, "myimage.gif");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    // Open the large object for reading
    int oid = rs.getInt(1);
    LargeObject obj = lobj.open(oid, LargeObjectManager.READ);

    // Read the data
    byte buf[] = new byte[obj.size()];
    obj.read(buf, 0, obj.size());
    // Do something with the data read here

    // Close the object
    obj.close();
}
rs.close();
ps.close();