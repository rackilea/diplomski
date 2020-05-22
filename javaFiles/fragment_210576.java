Semaphore semaphore = new Semaphore(dataArray.length);
    for (String data : dataArray) { 
        semaphore.acquire();        
        APIEndpoint apiCall = new APIEndpoint("http://sampleAPI.org/route/" + data);
        apiCall.execute(((response, success) -> {
            // Format and gather the info from the response
            apiDataArray.add(DataFromAPIObject);
            semaphore.release();
        }));
    }
    semaphore.acquire(dataArray.length);
    sortData();