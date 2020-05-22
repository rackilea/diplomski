public class MyRespWriter implements MessageBodyWriter<JsonResp> {

    @Context
    ResourceInfo ri;

    ...

    Annotations[] annos = ri.getResourceMethod().getAnnotations();