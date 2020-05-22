package mithrandirclient;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TestClient {

    @Inject
    @Client("http://localhost:8086")
    RxHttpClient httpClient;

    public String getRandomName(){

        System.out.println("getRandomName invoked => " + httpClient);

        return "Some Random Name";
    }
}