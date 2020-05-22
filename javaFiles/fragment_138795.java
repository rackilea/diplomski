public static void main(String[] args) throws IOException {
        String inputJson = "{\"Code\":2,\"Description\":\"OK\",\"Status\":0,\"Items\":[{\"City\":\"nameOfCity\",\"Country\":\"nameOfCountry\",\"CountryCode\":\"US\",\"Latitude\":\"11.11111\",\"Longitude\":\"-11.11111\",\"Name\":\"name of Company\",\"Region\":\"nameofRegion\",\"ServisID\":\"111AAA111AA\",\"SiteAddress\":\"number and street 2301\",\"ZipCode\":\"1111\"},{\"City\":\"nameOfCity2\",\"Country\":\"nameOfCountry\",\"CountryCode\":\"US\",\"Latitude\":\"22.22222\",\"Longitude\":\"22.2222222222\",\"Name\":\"name of Company2\",\"Region\":\"nameofRegion\",\"ServisID\":\"111BBB111BB\",\"SiteAddress\":"
                + null + ",\"ZipCode\":" + null + "}]}";
        JSONObject objJsonObject = new JSONObject(inputJson);
        JSONArray objJsonArray = objJsonObject.getJSONArray("Items");
        String csv = CDL.toString(objJsonArray);
        FileUtils.writeStringToFile(new File(System.getenv("HOME")+ "/temp.csv"), csv);
}