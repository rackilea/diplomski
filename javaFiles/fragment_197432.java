package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Transformer {
    private String datasource;

    @Autowired
    public Transformer(String datasource) {
        this.datasource=datasource;
        log.info(datasource);
    }
}