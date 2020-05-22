class PlaceITSpec extends Specification {
def "Create a Place"() {
given:
    def place = ['name' : 'Depot A',
                'location': [
                        'latitude': 40f,
                        'longitude': -3f
                ]]
    def request = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(place)

when: "POST /places"
    def response = request.with().post("http://localhost:8080/places")

then: "I get a the created place resource and 201 status code"
    response.then().log().all()
            .statusCode(201)
            .body("name", equalTo(place['name']))
            .body("location.longitude", equalTo(place['location']['longitude']))
            .body("location.latitude", equalTo(place['location']['latitude']))
            .body("_links.self", notNullValue())
            .body("_links.place", notNullValue())

  }
}