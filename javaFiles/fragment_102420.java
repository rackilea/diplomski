public List<CacheMetaData> getAllCacheName(){
        List<CacheMetaData> cacheMetaDataList=new ArrayList<>();
        for( Cache.Entry<String, GenericClassForList> entry : this.operatingParametersCache) {
            String key = entry.getKey();
            List<operatingParametersCache> value = entry.getValue();
            int size=value.size();
            cacheMetaDataList.add(new CacheMetaData<operatingParametersCache>(key,size,value));
        }

        for( Cache.Entry<String, GenericClassForList> entry : this.securitiesTradingParameterCache) {
            String key = entry.getKey();
            List<securitiesTradingParameterCache> value = entry.getValue();
            int size=value.size();
            cacheMetaDataList.add(new CacheMetaData<securitiesTradingParameterCache>(key,size,value));
        }

        for( Cache.Entry<String, GenericClassForList> entry : this.marketCloseStatisticsCache) {
            String key = entry.getKey();
            List<marketCloseStatisticsCache> value = entry.getValue();
            int size=value.size();
            cacheMetaDataList.add(new CacheMetaData<marketCloseStatisticsCache>(key,size,value));
        }

        return cacheMetaDataList;
    }