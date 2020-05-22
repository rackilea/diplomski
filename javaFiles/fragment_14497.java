while (db.conn.next()) {
    fVin fv = new fVin();
    fv.VIN = db.conn.getString(1);
    fv.fatals = (int)Float.parseFloat(db.conn.getString(2));              

    gl.fnVins.add(fv);
}