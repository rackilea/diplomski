package com.officedrop.uploader;

import java.io.File;
import java.net.URL;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

public class SampleUploader {

    public static void main(String[] args) throws Exception {

        DefaultHttpClient httpclient = new DefaultHttpClient();
        String basePath = "http://localhost/";

        URL url = new URL( basePath );

        HttpHost targetHost = new HttpHost( url.getHost(), url.getPort(), url.getProtocol() );  

        HttpPost httpost = new HttpPost( String.format( "%s%s", basePath, "ze/api/documents.xml"));

        MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

        entity.addPart("file_1", new FileBody( new File( "path-to-file.pdf" ) , "file.pdf", "application/pdf", null));
        entity.addPart("uploaded_data_1", new FileBody( new File( "path-to-file.json" ) , "file.json", "application/json", null));    

        httpost.setEntity(entity);

        HttpResponse response = httpclient.execute( targetHost, httpost);

    }

}