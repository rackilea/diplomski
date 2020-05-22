@Override
        protected Map<String,String> getParams() {
            Map<String,String> params = new HashMap<String,String>();
            params.put("fname",fname);
            params.put("lname",lname );
            ...
            return params;
        }