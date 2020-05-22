List<Request> requestList = new ArrayList<>();
Request request = new Request();
request.setDisplayText("etc");
... // set other stuff
requestList.add(request);
response = request.contentType("application/json").accept("*/*").body(requestList).put(ENDPOINT_GET_USER_BY_ID);