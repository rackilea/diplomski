private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


public static void processUrls(String[] blobs, Map<String, String[]> urls) {
    CkanClient cc = new CheckedCkanClient("HOSTNAME", "key");

    // Process each blob
    for (String dsName : blobs) {
        System.out.println("DATASET: " + dsName);

        // Process all the available URLS of the same blob
        List<String> urls = new ArrayList<>();
        String publisherName;
        String container;
        for (String url : urls.get(blob)) {
            System.out.println("URL: " + url);
            String[] urlFields = url.split("/");
            String fileName = urlFields[urlFields.length - 1];

            System.out.println(" - Resource " + fileName + " with URL " + url);

            urls.add(url);
        }

        // Construct the JSON metadata
        JSONObject metaData = createMetaData(dsName, urls, publisherName, container);
        System.out.println("METADATA: ");
        System.out.println(metaData.toJSONString());

        // Upload to CKAN
        ObjectMapper objectMapper = new ObjectMapper();
        CkanDataset cd = objectMapper.readValue(metaData, CkanDataset.class);
        CkanDataset createdDataset = cc.createDataset(cd);
    }
}

private JSONObject createMetaData(String dsName, List<String> urls, String publisherName, String container) {
    JSONArray metaDataUrls = new JSONArray();
    JSONArray urlTypes = new JSONArray();
    for (String url : urls) {
        metaDataUrls.put(url);
        String[] urlFields = url.split(".");
        urlTypes.put(urlFields[urlFields.length - 1]);
    }

    JSONObject metaData = new JSONObject();
    metaData.put(dsName, metaDataUrls);
    metaData.put("Title", "Dbpedia-" + dsName);
    metaData.put("Publisher", publisherName);
    metaData.put("Created", FORMAT.format(new Date()));
    metaData.put("version", "2016-10");
    metaData.put("Container", container);
    metaData.put("SourceType", urlTypes);

    return metaData;
}