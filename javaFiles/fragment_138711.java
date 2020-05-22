String payLoadLogin = "blahblahblah"

HttpPost httppost = new HttpPost(postAddress);
httppost.setHeader("X-GWT-Permutation", "3DE824138FE65400740EC1816A73CACC");
httppost.setHeader("Content-Type", "text/x-gwt-rpc; charset=UTF-8");
StringEntity se = new StringEntity(payLoadLogin );      
httppost.setEntity(se);