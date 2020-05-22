//Auth header
Map<String, String> mHeaderPart= new HashMap<>();
mHeaderPart.put("Content-type", "multipart/form-data;");
mHeaderPart.put("access_token", accessToken);

//File part
Map<String, File> mFilePartData= new HashMap<>();
mFilePartData.put("file", new File(mFilePath));
mFilePartData.put("file", new File(mFilePath));

//String part
Map<String, String> mStringPart= new HashMap<>();
mStringPart.put("profile_id","1");
mStringPart.put("imageType", "ProfileImage");

CustomMultipartRequest mCustomRequest = new CustomMultipartRequest(method, mContext, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                listener.onResponse(jsonObject);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onErrorResponse(volleyError);
            }
        }, mFilePartData, mStringPart, mHeaderPart);