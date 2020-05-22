package com.example.misc;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.PreemptiveBasicAuthScheme;
import org.junit.BeforeClass;

public class QueryEndpoint {
    static String userName = "username123";
    static String password = "password123";
    @BeforeClass
    public static void setup() {
        RestAssured.port = 8010;
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(userName);
        authScheme.setPassword(password);
        RestAssured.authentication = authScheme;

        String basePath;
        basePath = "/api/version1/";
        RestAssured.basePath = basePath;

        String baseHost;
        baseHost = "http://localhost";
        RestAssured.baseURI = baseHost;
        }

    }