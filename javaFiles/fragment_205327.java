// Must call this to release the connection
        // #1.1.5 @
        // http://hc.apache.org/httpcomponents-client-ga/tutorial/html/fundamentals.html
        HttpEntity enty = response.getEntity();
        if (enty != null)
            enty.consumeContent();