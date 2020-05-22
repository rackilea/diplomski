URL url = new URL("https://localhost:8080/test");
HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
urlc.setDoInput(true);
urlc.setDoOutput(true);
urlc.setRequestMethod("POST");
urlc.setRequestProperty("Accept", "application/x-protobuf");
urlc.setRequestProperty("Content-Type","application/x-protobuf");
TestRequestPb.TestRequest.Builder testRequestBuilder = TestRequestPb.TestRequest.newBuilder();
TestRequest testRequest = testRequestBuilder.build();
testRequest.writeTo(urlc.getOutputStream());

testRequest = TestRequest.newBuilder().mergeFrom(urlc.getInputStream()).build();