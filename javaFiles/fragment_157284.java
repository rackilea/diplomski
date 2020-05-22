String payload;
//send model WITHOUT nulls
payload = new Gson().toJson(MyModel.builder().field("someValue").build());
when().contentType(ContentType.JSON).body(payload).put("http://my-service.com/myendpoint/").then().statusCode(200);

//send model WITH nulls
payload = new GsonBuilder().serializeNulls().create().toJson(MyModel.builder().field("someValue").build());
when().contentType(ContentType.JSON).body(payload).put("http://my-service.com/myendpoint/").then().statusCode(200);