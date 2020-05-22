@RestController
public class MyController {  

 @GetMapping(value = "/read", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity read() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<RMSendPropertyResponse> response = restTemplate.exchange("http://localhost:8080/", HttpMethod.GET, null, RMSendPropertyResponse.class);
    RMSendPropertyResponse rmResponse = response.getBody();
    return new ResponseEntity<>(rmResponse, HttpStatus.CREATED);

}

@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public String get() {
    return "{\n" +
            "    \"message\": \"Something failed.\",\n" +
            "    \"success\": false,\n" +
            "    \"errors\": [\n" +
            "        {\n" +
            "            \"error_code\": \"MND_00026\",\n" +
            "            \"error_value\": \"\",\n" +
            "            \"error_description\": \"field not present\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"error_code\": \"VAL_00039\",\n" +
            "            \"error_value\": \"0\",\n" +
            "            \"error_description\": \"Wrong field\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"warnings\": null,\n" +
            "    \"request_timestamp\": \"18-07-2017 11:34:46\",\n" +
            "    \"response_timestamp\": \"18-07-2017 11:34:46\"\n" +
            "}";
  }

}

@JsonIgnoreProperties(ignoreUnknown = true)
class RMError {
    private String error_code;
    private String error_description;
    private String error_value;

    public RMError() {
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public String getError_value() {
        return error_value;
    }

    public void setError_value(String error_value) {
        this.error_value = error_value;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class RMSendPropertyResponse {

    private List<RMError> errors;

    public RMSendPropertyResponse() {
    }

    public List<RMError> getErrors() {
        return errors;
    }

    public void setErrors(List<RMError> errors) {
        this.errors = errors;
    }
}