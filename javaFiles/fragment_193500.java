for(String value : keyFormat) {
    System.out.println("--> "+value);
    mostrarBotonBuscar = mostrarBotonBuscar || value.endsWith(CODIGO_BUSCAR);
    mostrarBotonNuevo = mostrarBotonNuevo || value.endsWith(CODIGO_NUEVO);
    mostrarBotonModificar = mostrarBotonModificar || value.endsWith(CODIGO_MODIFICAR);
    mostrarBotonEliminar = mostrarBotonEliminar || value.endsWith(CODIGO_ELIMINAR);
    mostrarBotonConsultar = mostrarBotonConsultar || value.endsWith(CODIGO_CONSULTAR);
}