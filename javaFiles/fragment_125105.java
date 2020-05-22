@Override
        protected Map<String,String> getParams(){
            Map<String,String> params = new HashMap<String, String>();
            params.put(KEY_USERNAME,username);
            params.put(KEY_PASSWORD,password);
            params.put(KEY_EMAIL, email);
            return params;
        }