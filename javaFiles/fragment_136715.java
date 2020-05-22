import javax.ws.rs.core.Context;
    import javax.ws.rs.core.UriInfo;
    import javax.ws.rs.PathParam;
    import javax.ws.rs.Produces;
    import javax.ws.rs.Consumes;
    import javax.ws.rs.GET;
    import javax.ws.rs.Path;
    import javax.ws.rs.PUT;
    import javax.ws.rs.POST;

    import java.util.Iterator;

    import org.json.simple.JSONObject;
    import org.json.simple.JSONArray;
    import org.json.simple.JSONValue;
    import org.json.simple.parser.JSONParser;
    import org.json.simple.parser.ParseException;

    /**
     * REST Web Service
     *
     * @author Aj
     *
     * This service will return the offers valid for the IMSI number passed
     */
    @Path("getOffers")
    public class GetOffersResource {

        @Context
        private UriInfo context;

        /**
         * Creates a new instance of GetOffersResource
         */
        public GetOffersResource() {
        }

        @POST
        @Consumes("application/json")
        @Produces("application/json")
        public String getJson(jsonFormat jsonObj) {

            String[] response = new String[5];

            offerProcess ofc = new offerProcess();

            try {

                ofc.setLatitude(jsonObj.latitude);
                ofc.setLongitude(jsonObj.longitude);
                ofc.setIMSI(jsonObj.IMSI);

            } catch (Exception e) {
                JSONObject ser = new JSONObject();

                ser.put("status", "error");
                ser.put("reason", jsonObj.latitude);

                return ser.toJSONString();
            }

            //TODO return proper representation object
            JSONObject ser = new JSONObject();
            JSONArray arr = new JSONArray();

            arr.add("456TYU");
            arr.add("OLED TV");
            arr.add("24-JUL-2014");
            arr.add("XYZ Enterprises");
            arr.add("Gachibowli");
            arr.add("9911278366");

            ser.put("status", "success");
            ser.put("Offers", ofc.getIMSI());

            System.out.println(ser);

            return ser.toJSONString();
        }

        /**
         * PUT method for updating or creating an instance of GetOffersResource
         *
         * @param content representation for the resource
         * @return an HTTP response with content of the updated or created resource.
         */
        @PUT
        @Consumes("application/json")
        public void putJson(String content) {
        }
    }