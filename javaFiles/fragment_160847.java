HashMap hashMap = new HashMap<String, RequestBody>();
 RequestBody fileReqBody = RequestBody.create(
              MediaType.parse("multipart/form-data"), new File(path));
 hashMap.put("datafile\"; filename=\"image_" 
                          + System.currentTimeMillis() 
                          +".jpeg\"", fileReqBody);