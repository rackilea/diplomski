package com.company.module.test;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.company.common.DateUtil;
import com.company.module.input.AssetOperation;
import com.company.module.input.AssetOperationData;
import com.company.module.result.AssetResult;

public class MainProg002 {

    public static void main(String[] args) throws Exception {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        client.addFilter(new LoggingFilter());

        WebResource service = client.resource(getBaseURI());

        AssetOperationData data = new AssetOperationData();
        AssetOperation op1 = new AssetOperation();
        op1.setAssetID("1234");
        op1.setDate(DateUtil.getDate(2013, 12, 22));
        op1.setOperation("pause");
        AssetOperation op2 = new AssetOperation();
        op2.setAssetID("5050");
        op2.setDate(DateUtil.getDate(2013, 12, 5));
        op2.setOperation("resume");
        data.getAssetOperations().add(op1);
        data.getAssetOperations().add(op2);

        String res = service.path("Asset").entity(data, MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_JSON).post(String.class);
        Gson gson = new Gson();
        AssetResult result = gson.fromJson(res, AssetResult.class);

        System.out.println("DONE!");
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/module/service").build();
    }
}