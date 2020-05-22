public Prestamo buscarPrestamoPorUUID(UUID idPrestamo, ArrayList<Prestamo> listaBuscar) {
    Iterator<Prestamo> it = listaBuscar.iterator();
    Prestamo esteElemento;
    while (it.hasNext()) {
        esteElemento = it.next();
        if (esteElemento.getActivo() && esteElemento.getIdPrestamo().equals(idPrestamo)) {
            return esteElemento;
        }
    }

    throw new RuntimeException("Didn't find an entity with the provided UUID!");
}