result = new String();
JsonNode node = mapper.readTree(slRealTimeClient.getJson(depatureSite));
node = node.path("Departure").path("Metros").path("Metro");
JsfUtil.debug("Node size: " + node.size());
depatureSiteResponse = node.get(0).path("SiteId").getTextValue();
for (JsonNode element : node) {
    if (!element.isNull()) {
        result += element.get("StationName").getTextValue();
        result += ":" + System.getProperty("line.separator");
        result += element.get("DisplayRow1").getTextValue();
        result += System.getProperty("line.separator");
        result += element.get("DisplayRow2").getTextValue();
        result += System.getProperty("line.separator");
    }
}