class Abc {
ResponseEntity<String> = response;
static final String url = "https://abc-xyz.com/client-rest-end-point-url";
public ResponseEntity getDetails(RequestInput requestInput) {
       if(requestInput==null){
          throw new TestException("FAILED", "1", "Data can't be null");
    }