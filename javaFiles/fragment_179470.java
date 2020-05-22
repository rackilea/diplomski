HttpResponse r = null;

        if(params[1] == "GETRESULT")
        {
            HttpGet get = new HttpGet(params[0]);
            r = client.execute(get);
        }

        else //we are posting
        {
            HttpPost post = new HttpPost(params[0]);
            r = client.execute(post);
        }

        StatusLine httpStatus = r.getStatusLine();
        HttpEntity e = r.getEntity();