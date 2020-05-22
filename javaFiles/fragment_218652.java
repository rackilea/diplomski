@Provider
public class SummerResponseFilter implements ContainerResponseFilter {

@Override
public ContainerResponse filter(ContainerRequest request, ContainerResponse response) 
{

    //INICIO OT 10533 - PSC001
    String ruta = request.getPath();

    if(ruta.contains("pcnct020")){
        response.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHttpHeaders().add("Access-Control-Allow-Methods","GET, OPTIONS, 
        HEAD, PUT, POST");
        response.getHttpHeaders().add("Access-Control-Allow-Headers","Content-Type");

    }

    //FIN OT 10533 - PSC001

    if (Logger.isDebugEnabled()) {
        Logger.debug("Finaliza el proceso de la url [%s] %s", request.getMethod(), 
       request.getRequestUri().toString());
    }
    if (Logger.isTraceEnabled()) {
        Logger.trace("Response - Headers    = [ %s ]",           
        response.getHttpHeaders().toString());
        Logger.trace("Response - Status     = [ %d ]", response.getStatus());
    }
    Answer.clean();
    return response;
 }