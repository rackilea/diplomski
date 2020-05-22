AsyncHttpClient asyncHttpClient=new AsyncHttpClient();
RequestParams params=new RequestParams();
        params.put("username", uname);
        params.put("password", pass);
            asyncHttpClient.post("http://10.0.2.2/fanaticmobile/log_in.php", params,new AsyncHttpResponseHandler(){
                @Override
                public void onFailure(Throwable arg0, String arg1) {
                    // TODO Auto-generated method stub
                    super.onFailure(arg0, arg1);
                }
                @Override
                public void onSuccess(String arg0) {
                    // TODO Auto-generated method stub
                    super.onSuccess(arg0);
                }
            });