package com.oliverlockwood;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Main {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
    }
}