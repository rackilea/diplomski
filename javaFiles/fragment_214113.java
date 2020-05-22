String ordenObtenida = "{\"status\":\"ok\",\"tipo\":\"" + tipo + "\",\"ordenes\":\[;
    while (rs.next()) {
        hasRow = true;
        if (rs.getString("razon") != null) {
            razon = rs.getString("razon").replaceAll("\"", "").trim();
        }
        ordenObtenida += "{\"numero\":\"" + rs.getInt("numero") + "\",\"fecha\":\"" + rs.getDate("fecha") + "\",\"proveedor\":\"" + rs.getInt("proveedor") + "\","
                + "\"codigo\":\"" + rs.getInt("codigo") + "\",\"orden\":\"" + rs.getInt("orden") + "\",\"fepago\":\"" + rs.getDate("fepago") + "\",\"marca\":\"" + rs.getInt("marca") + "\","
                + "\"razon\":\"" + razon + "\",\"importe\":\"" + rs.getFloat("importe") + "\"},";
    }
    ordenObtenida = ordenObtenida.substring(0, ordenObtenida.length() - 1) + "]\"}";