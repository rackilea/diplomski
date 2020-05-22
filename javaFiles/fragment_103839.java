@Path("/MyRestService/{wordToTranslate}/{fromLanguage}/{toLanguage}")
@GET
public String doGet(@PathParam("wordToTranslate") String wordToTranslate, 
@PathParam("fromLanguage") String fromLanguage, @PathParam("toLanguage")  String toLanguage) throws Exception

Invocation: curl -X GET http://localhost:8080/MyRestService/x/y/z