public static void main(String[] args) throws IOException {

    AmazonEC2 client = AmazonEC2Client.builder().build();
    DescribeSpotPriceHistoryRequest request = new DescribeSpotPriceHistoryRequest()
        .withEndTime(new Date())
        .withInstanceTypes("m1.xlarge").withProductDescriptions("Linux/UNIX (Amazon VPC)")
        .withStartTime(new Date());
    DescribeSpotPriceHistoryResult response = client.describeSpotPriceHistory(request);

    ObjectMapper mapper = new ObjectMapper();
    String asPrettyJSon = mapper.writerWithDefaultPrettyPrinter()
        .writeValueAsString(response.getSpotPriceHistory());
    System.out.println(asPrettyJSon);
    }