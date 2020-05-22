String id = UUID.randomUUID().toString();
DataOfInterest data = new DataOfInterest(request);
Map<String, DataOfInterest> map = (Map<String, DataOfInterest) session.getAttribute("dataOfInterest");
map.put(id, data);
returnToUrl += "?token=" + URLEncoder.encode(id, "UTF-8");
// ...