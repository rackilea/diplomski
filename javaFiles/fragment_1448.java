package com.type.GetFuelTypeFromAPI;

import static io.restassured.RestAssured.given;

import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class SampleGetAPI {

@Test
public void getDetails() throws MalformedURLException {

    Response response=
    given()
        .header("User-Agent", "PostmanRuntime/7.6.0")
        .queryParam("cmd", "getTrims")
        .queryParam("make", "Abarth")
        .queryParam("year", "1955")
        .queryParam("model", "207")
    .when()
        .get(new URL("https://carqueryapi.com/api/0.3/"));

    String responseBody = response.body().asString();
    System.out.println(responseBody);
}
}