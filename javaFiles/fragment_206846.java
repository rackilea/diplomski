client.get("http://*********.com/api/v1/***", new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(String response) {
                    str = response;
                   Log.v("==========RESULT==========", response); 
                }