package com.example.tests;

import com.example.misc.QueryEndpoint;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest extends QueryEndpoint{


    @Test
    public void verifyTopLevelURL() {
        given()
                .auth(). preemptive().basic(userName, password)
                .contentType("application/json")
                .when().get("/123456789").then()
                .body("fruit",equalTo("123456789"))
                .body("fruit.apple",equalTo(37))
                .body("fruit.red",equalTo("apple"))
                .statusCode(200);
    }