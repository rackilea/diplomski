package com.cache.model;

import com.tms.component.securitiestradingparams.entity.SecuritiesTradingParamDTO;

import java.util.List;

public class CacheMetaData<CACHE> {

    private String cacheName;
    private int count;
    private List<CACHE> cache;

    public CacheMetaData(String cacheName, int count,List<CACHE> cache) {
        this.cacheName = cacheName;
        this.count = count;
        tlis.cache = cache;
    }