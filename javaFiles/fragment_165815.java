sSQL = "UPDATE datos " +
            "SET apellido1 = ?," +
            "apellido2 = ?," +
            "nombre = ?," +
            "genero = ?," +
            "telefono1 = ?," +
            "telefono2 = ?," +
            "carrera = ?," +
            "promedio = ?," +  // <<== remove this trailing comma
            "WHERE ficha = " +id_actualizar;