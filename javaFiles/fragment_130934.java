package com.example.editor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class Configuration {

    @Value("$(url)")
    private String hostURL;

    public String getHostURL(){
        System.out.println("URL:"+this.hostURL);
        return this.hostURL;
    }