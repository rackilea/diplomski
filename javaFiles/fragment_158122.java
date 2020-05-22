for (Document d : lineaCompra) {
    LineaCompra() aux2 = new LineaCompra();
    aux2.setTitulo(d.getString("idProducto"));
    aux2.setPrecio(d.getDouble("precio").floatValue());
    aux2.setCantidad(lineasObj.getInteger("cantidad"));
    lineas.add(aux2);
}