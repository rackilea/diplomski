public class GetStatusHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

private static final Logger LOG = Logger.getLogger(GetStatusHandler.class);

@SuppressWarnings("unchecked")
public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {

    BasicConfigurator.configure();

    LOG.info("received: " + input);

      try {

         Map<String, String> pathParameters = (Map<String, String>) input.get("queryStringParameters");

         if(pathParameters == null) {

             LOG.info("Getting details for all persons ");
              PersonControl control = new PersonControl();
              Person[] result = control.myGetHandler(context); 
              return ApiGatewayResponse.builder()
                        .setStatusCode(200)
                        .setObjectBody(result)
                        .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
                        .build();

         }else {

             String name = pathParameters.get("name"); 
             LOG.info("Getting details for "+name);
             PersonControl control = new PersonControl();
             Person result = control.myGetHandler(name, context);
             return ApiGatewayResponse.builder()
                        .setStatusCode(200)
                        .setObjectBody(result)
                        .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
                        .build();

         }


        }catch(Exception e) {

            LOG.error(e, e);
            Response responseBody = new Response("Failure getting person", null);

            return ApiGatewayResponse.builder()
                  .setStatusCode(500)
                  .setObjectBody(responseBody)
                  .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
                  .build();
        }
    }
}