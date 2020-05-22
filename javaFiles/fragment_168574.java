import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

...

given()
    .contentType(CONTENT_TYPE_APPLICATION_JSON)
.when()
    .get(getRestOperationPath())
.then()
    .statusCode(anyOf(is(STATUS_CODE_OK),is(STATUS_CODE_NOT_FOUND)));