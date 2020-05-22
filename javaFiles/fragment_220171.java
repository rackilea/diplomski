@Override
public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
    int response = responseContext.getStatus();
    Object entidad = responseContext.getEntity();
    if (entidad != null && response == 200) {
        int nroRegistros = (entidad instanceof List) ? (((List) entidad).size()) : 1;
        Map<String, Object> respuesta = Maps.newHashMap();
        respuesta.put("data", entidad);
        if(nroRegistros != 1) {
            respuesta.put("numero_reg", nroRegistros);                
        }
        responseContext.setEntity(respuesta);
    }
}