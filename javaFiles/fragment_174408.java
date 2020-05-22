String apiUrl = "http://api.website.com/service/getLocationInformations";
RequestObject requestObject = new RequestObject();
// create pointList and add to requestObject
requestObject.setPointList(pointList);

RestTemplate restTemplate = new RestTemplate();
ResponseObject response = restTemplate.postForObject(apiUrl, requestObject, ResponseObject.class);

// response.getSuccess(), response.getStatusCode(), response.getStatus(), response.getLocationInfo() can be used