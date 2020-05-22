// Instantiate the cache
        Cache cache = new DiskBasedCache(mContext.getCacheDir(), 1024 * 1024); // 1MB cap

        // Set up the network to use HttpURLConnection as the HTTP client.
        BasicNetwork network = new BasicNetwork(new HurlStack());

        mRequestQueue = new RequestQueue(cache, network, 29);
//The Integer 29 indicate the number of requests, 
//hence, the number of concurrent threads volley will run on its Looper and 
//Handler.

        // Start the queue
        mRequestQueue.start();

       //Make request here