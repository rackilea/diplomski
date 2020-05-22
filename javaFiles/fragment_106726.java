String insertSQL = "insert into registros(id_registro, job, ip, id_parte, fecha,"
    + "id_inspector, id_descripcion, piezasrech, piezasinsp, "
    + "id_disposicion, id_area, id_responsable, id_estacion) "
    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
Conexion.ins.execute(insertSQL,
    txtOrder.getText(), txtIP.getText(), id_parte, fecha,
    id_inspector, id_descripcion, txtPR.getText(), txtPI.getText(),
    id_disposicion, id_area, id_responsable, id_estacion);