@Override
public Set<Despacho> getDespachos() {
    Set<Despacho>  despachos = new HashSet<Despacho>();
    for (Espacio e : espacio) {
        // Not sure, depends on the definition of TipoEspacio
        if (e.getTipo() == TipoEspacio.DESPACHO && e instanceof Despacho) {
          despachos.put((Despacho)e);
         }
    }
    return despachos;
}