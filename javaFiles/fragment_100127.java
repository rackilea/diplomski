String response = Request.Post(newStringBuilder(API_BASE_URL)
.append("/folders").toString()
.addHeader("Authorization", API_REQUEST_HEADER)
.bodyString(new StringBuilder("{\"name\":\"").append(name)
.append("\", \"parent\": {\"id\": \"").append(parent_folder_id).append("\"}}")
.toString(), ContentType.DEFAULT_TEXT)
.execute().handleResponse(myResponseHandler);